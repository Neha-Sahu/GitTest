// ***********************************************************
// This example support/e2e.js is processed and
// loaded automatically before your test files.
//
// This is a great place to put global configuration and
// behavior that modifies Cypress.
//
// You can change the location of this file or turn off
// automatically serving support files with the
// 'supportFile' configuration option.
//
// You can read more here:
// https://on.cypress.io/configuration
// ***********************************************************

// Import commands.js using ES2015 syntax:
import './commands'
// cypress/support/e2e.js   ← this file runs before every test

Cypress.on('uncaught:exception', (err, runnable) => {
  // Amazon throws tons of " Things went bad" or null errors from 3rd party scripts
  if (err.message.includes('Things went bad') || 
      err.message.includes('null') || 
      err.message.includes('Script error') ||
      err.message.includes('ResizeObserver') ||
      err.message.includes('Minified') ) {
    // we expected this error, so let's ignore it
    return false
  }
  // Let other real errors fail the test
})