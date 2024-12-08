/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function validateForm(context) {
    let maximumAllowedPrice = 99999.99;

    let flagValid = true;
    for (const form of Array.prototype.slice.call(document.forms)) {
        if (form.contains(context)) {
            var formToValidate = form;
            break;
        }
    }

    if (formToValidate) {
        Array.prototype.slice.call(formToValidate.elements).filter(element => {
            return element.hasAttribute("type") && (element.getAttribute("type") === "text" || element.getAttribute("type") === "password");
        }).forEach(element => {
            //Validate existent
            if (!element.value && parseInt(element.value) !== 0) {
                //alert(element.getAttribute("name").charAt(0).toUpperCase() + element.getAttribute("name").slice(1) + " is a required field.");
                element.nextSibling.textContent = "*";
                flagValid = false;
                return;
            } else {
                element.nextSibling.textContent = "";
            }

            if (element.getAttribute("name") === "price") {
                //Validate numeric
                if (!element.value.match(new RegExp('^\\$?\\d+\\.?\\d{0,2}$'))) {
                    alert("Price must be a currency-formatted number greater than 0.");
                    flagValid = false;
                    return;
                }

                if (parseFloat(element.value) > maximumAllowedPrice) {
                    alert("Price is constrained to $" + maximumAllowedPrice + " and below.");
                    flagValid = false;
                    return;
                }
            } else if (element.getAttribute("name") === "description") {
                //Validate length
                if (element.value.length > 100) {
                    alert("Product descriptions are constrained to 100 characters or less.");
                    flagValid = false;
                    return;
                }
            } else if (element.getAttribute("name") === "code") {
                //Validate length
                if (element.value.length > 10) {
                    alert("Product codes are constrained to 10 characters or less.");
                    flagValid = false;
                    return;
                }
            } else if (element.getAttribute("name") === "username") {
                //Validate length
                if (element.value.length > 32) {
                    alert("Usernames are constrained to 32 characters or less.");
                    flagValid = false;
                    return;
                }
            } else if (element.getAttribute("name") === "password") {
                //Validate length
                if (element.value.length > 32) {
                    alert("Passwords are constrained to 32 characters or less.");
                    flagValid = false;
                    return;
                }
            } 
        });
    } else {
        flagValid = false;
    }

    //All fields valid?
    if (flagValid) {
        formToValidate.submit();
    } else {
        window.event.preventDefault();
    }
}