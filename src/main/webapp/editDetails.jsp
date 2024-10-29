<html>
    <head>
        <title>
            Registration form
        </title>
        <link rel="stylesheet" href="editstyles.css">
    </head>
    <body>
        <div class="container">
            <div class="img">
                <img src="img/1.jpeg" alt="img">
            </div>
            <div class="form">
                <form action="EditServlet" method="post">
                    <h1>Student Registration Form</h1>
                    <label for="name">Student Name:</label>
                    <input type="text" name="name" value = "${student.name}">
                    <br>
                    <label for="email">Student Mail:</label>
                    <input type="email" name="email" value = "${student.email}">
                    <br>
                    <label for="dob">Student DOB:</label>
                    <input type="date" name="dob" value = "${student.date}">
                    <br>
                    <br>
                    <label for="password">Password:</label>
                    <input type="password" name="password" value = "${student.password}">                    
                    <br>
                    <label for="gender">Gender:</label>
                    <select name="gender" >
                        <option value = "${student.gender}">${student.gender}</option>
                        <option value="male">Male</option>
                        <option value="female">Female</option>
                        <option value="other">Others</option>
                    </select>
                    
                    <button type="submit" name="edit" value="edit">Submit</button>
                    <button type="reset">Reset</button>
                </form>
            </div>
        </div>
    </body>
</html>