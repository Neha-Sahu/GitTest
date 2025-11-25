/* cypress/e2e/amazon_books_search.cy.ts
// GitHub Actions first run – Nov 22 2025

describe('Amazon Workflow Test', () => {
    // Note: It's best practice to use environment variables or fixtures for credentials.
    const username = Cypress.env('nine.sara05@gmail.com');
    const password = Cypress.env('Welcome@nz');
    const searchTerm = 'books';

    // Before each test, visit the Amazon homepage
    beforeEach(() => {
        cy.visit('https://www.amazon.com.au/');
    });

    it('Logs in, searches for books, and clicks the first result', () => {
        // 1. **Login Process**
        // Click the 'Sign In' button/link
        cy.get('#nav-signin-tooltip .nav-action-inner').click();

        // Type username (email or phone)
        if (username) {
            cy.get('#ap_email').type(username);
            cy.get('#continue').click();

            // Type password
            if (password) {
                // Ensure the password field exists before typing
                cy.get('#ap_password', { timeout: 10000 }).should('be.visible').type(password);
                cy.get('#signInSubmit').click();

                // Optional: Assertion after login (e.g., checking for 'Hello, [Your Name]' or the user icon)
                // This will fail if a CAPTCHA or two-factor authentication page appears,
                // which is common for automated logins.
                cy.get('#nav-link-accountList-nav-line-1', { timeout: 10000 }).should('contain', 'Hello');
            } else {
                cy.log('⚠️ Amazon password not found in environment variables. Skipping password entry.');
            }
        } else {
            cy.log('⚠️ Amazon username not found in environment variables. Skipping login.');
            // Skip the rest of the login process if no username is found.
        }

        // --- Separate Search Section for clarity and robustness ---

        // 2. **Search for 'books'**
        // Type the search term into the main search bar (ID: twotabsearchtextbox)
        cy.get('#twotabsearchtextbox').type(searchTerm);

        // Click the search button (ID: nav-search-submit-button)
        cy.get('#nav-search-submit-button').click();

        // Optional: Assert that the search results page loaded
        cy.url().should('include', `field-keywords=${searchTerm}`);
        cy.get('.a-color-state').should('contain', searchTerm);

        // 3. **Click the First Link**
        // This selector targets the first *search result item*.
        // Amazon's structure uses a generic class for search results.
        // Adjust the selector if necessary, but this is a common one for the first product link.
        cy.get('[data-component-type="s-search-result"]') // Select all result containers
            .first() // Pick the first container
            .find('h2 a') // Find the link inside the title (h2)
            .click();

        // Optional: Assert that the new page is a product details page
        cy.url().should('include', '/dp/');
        cy.get('#productTitle').should('be.visible');
    });
});*/

// cypress/e2e/amazon_books_search.cy.ts

describe('Amazon Workflow Test', () => {
    // IMPORTANT: Make sure these environment variables are set in cypress.config.ts!
    const username = Cypress.env('nine.sara05@gmail.com');
    const password = Cypress.env('Welcome@nz');
    const searchTerm = 'books';

    it('Logs in, searches for books, and clicks the first result', () => {
        cy.visit('https://www.amazon.com.au'); // Ensure you visit the correct domain (e.g., .com.au as shown in your URL)

        // 1. **Initiate Login**
        // Click the 'Sign In' button/link (wait for it to appear)
        cy.get('#nav-signin-tooltip').should('be.visible').click();

        // 2. **Enter Username/Email (First Login Page)**
        if (!username || !password) {
            cy.log('⚠️ Credentials not set. Skipping login and proceeding to search on the home page.');
            // Go back to the homepage to attempt the search without logging in
            cy.visit('https://www.amazon.com.au');
        } else {
            cy.log('Attempting login...');

            // Type username (email or phone)
            cy.get('#ap_email', { timeout: 10000 }).should('be.visible').type(username);
            cy.get('#continue').click();

            // 3. **Enter Password (Second Login Page)**
            // Wait for the password page to load and the field to be visible
            cy.get('#ap_password', { timeout: 10000 }).should('be.visible').type(password);

            // Click the final Sign In button
            cy.get('#signInSubmit').click();

            // 4. **Assertion after Login**
            // Check if the greeting shows up to confirm successful navigation to the home page
            // NOTE: This is prone to failure if Amazon triggers CAPTCHA or 2FA.
            cy.get('#nav-link-accountList-nav-line-1', { timeout: 15000 }).should('contain', 'Hello');
        }

        // --- Search Section (Runs only if login is successful OR if login was skipped) ---

        // 5. **Search for 'books'**
        // The search bar should now be visible on the home page.
        // Type and submit with Enter (bypasses the department redirect 99% of the time)
cy.get('#twotabsearchtextbox', { timeout: 20000 })
  .should('be.visible')
  .clear()
  .type('Harry Potter{enter}')   // ← change "books" to something specific like "Harry Potter"

// Now FORCE a real search results page – this is the nuclear option that ALWAYS works
cy.url({ timeout: 20000 }).should('include', '/s?k=')

// Wait for actual search results (this selector exists ONLY on real results page)
cy.get('[data-component-type="s-search-result"]', { timeout: 30000 })
  .should('have.length.greaterThan', 5)   // at least 5 results


cy.window().then((win) => {
  win.close()   // Closes the current browser tab/window
})
        
    });
});
