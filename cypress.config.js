// cypress.config.js  (or .ts)
const { defineConfig } = require('cypress')

module.exports = defineConfig({
  e2e: {
    baseUrl: 'https://www.amazon.com',   // optional, makes cy.visit('/') work
    experimentalSessionAndOrigin: true,  // helps stability
    viewportWidth: 1920,
    viewportHeight: 1080,
    video: true,
    screenshotsFolder: 'cypress/screenshots',
    videosFolder: 'cypress/videos',

    // ←←← ADD ALL THESE OPTIONS BELOW TO BEAT AMAZON BOT DETECTION ←←←
    chromeWebSecurity: false,
    defaultCommandTimeout: 15000,
    pageLoadTimeout: 60000,
    requestTimeout: 15000,

    // This is the magic line that bypasses most Cloudflare/Amazon anti-bot checks
    experimentalModifyObstructiveThirdPartyCode: true,

    setupNodeEvents(on, config) {
      // Optional: extra stealth (even stronger)
      on('before:browser:launch', (browser = {}, launchOptions) => {
        if (browser.name === 'chrome' || browser.name === 'chromium' || browser.name === 'edge') {
          launchOptions.args.push('--disable-blink-features=AutomationControlled')
          launchOptions.args.push('--no-sandbox')
          launchOptions.args.push('--disable-dev-shm-usage')
          launchOptions.args.push('--disable-features=IsolateOrigins,site-per-process')
          launchOptions.args.push('--disable-site-isolation-trials')
        }
        return launchOptions
      })
    },
  },
})
