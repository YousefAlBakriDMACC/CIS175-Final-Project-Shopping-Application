/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function validateForm(context) {
    let maximumAllowedPrice = 99.99;

    let flagValid = true;
    let formToValidate = undefined;
    for (const form of Array.prototype.slice.call(document.forms)) {
        if (form.contains(context)) {
            formToValidate = form;
            break;
        }
    }

    if (formToValidate) {
        Array.prototype.slice.call(formToValidate.elements).filter(element => {
            return element.hasAttribute("type") && element.getAttribute("type") === "text";
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

            //Validate numeric
            if (element.getAttribute("name") === "price") {
                let price = element.value;
                if (parseFloat(price) != price) {
                    alert("Price must be numeric.");
                    flagValid = false;
                    return;
                }
                
                if (parseFloat(price).toFixed(2) !== price) {
                    alert("Price is constrained to currency precision (0.01).");
                    flagValid = false;
                    return;
                }

                if (parseFloat(price) <= 0) {
                    alert("Price must be greater than 0.");
                    flagValid = false;
                    return;
                }

                if (parseFloat(price) > maximumAllowedPrice) {
                    alert("Price is constrained to " + maximumAllowedPrice + ".");
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
        return;
    }
}