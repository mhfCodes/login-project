<h1>Login App By Cookie</h1>
<p>in this project i have used servlets and cookies to store user status</p>
<p>There are 3 servlets in this project: 1-LoginServlet: This is the servlet which gets 
user's username and password and checks it against the database. if they are correct a cookie is created. 2-ProfileServlet: in this servlet we check for the cookie. if there is a cookie then we're logged in and if there is no cookie then we are not. 3-LogoutServlet: When the user clicks logout button, this servlet destroys the cookie so that user gets logged out</p>
<p>Also for connecting to database i've used JDBC and postgresql</p>