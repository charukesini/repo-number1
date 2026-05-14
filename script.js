const contactForm = document.getElementById("contactForm");

contactForm.addEventListener("submit", function(e){

    e.preventDefault();

    // GET VALUES

    const name =
        document.getElementById("name").value;

    const email =
        document.getElementById("email").value;

    const phone =
        document.getElementById("phone").value;

    // CREATE FORM DATA

    const formData =
        new URLSearchParams();

    formData.append("name", name);

    formData.append("email", email);

    formData.append("phone", phone);

    // SEND DATA TO JAVA SERVLET

    fetch(

        "http://localhost:8080/MaviProject/contact",

        {

            method: "POST",

            headers: {

                "Content-Type":
                "application/x-www-form-urlencoded"

            },

            body: formData.toString()

        }

    )

    .then(function(response){

        return response.text();

    })

    .then(function(data){

        alert(data);

        // CLEAR FORM

        document.getElementById("contactForm").reset();

    })

    .catch(function(error){

        console.log(error);

        alert("Error while submitting form");

    });

});