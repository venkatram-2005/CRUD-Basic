<html>
    <head>
        <title>
            Registration form
        </title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <div class="container">
            <div class="img">
                <img src="img/1.jpeg" alt="img">
            </div>
            <div class="form">
                <form action="RegistrationServlet" method="post">
                    <h1>Student Registration Form</h1>
                    <label for="name">Student Name:</label>
                    <input type="text" name="name">
                    <br>
                    <label for="email">Student Mail:</label>
                    <input type="email" name="email">
                    <br>
                    <label for="dob">Student DOB:</label>
                    <input type="date" name="dob">
                    <br>
                    <label for="gender">Gender:</label>
                    <select name="gender">
                        <option value="">Select</option>
                        <option value="male">Male</option>
                        <option value="female">Female</option>
                        <option value="other">Others</option>
                    </select>
                    <br>
                    <label for="password">Password:</label>
                    <input type="password" name="password">                    
                    <br>
                    <button type="submit">Submit</button>
                    <button type="reset">Reset</button>
                </form>
            </div>

        </div>
    </body>
</html>