   <%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
 <div id="testheader">
      <div class="container">
            <div class=row>        
                <div class="col-md-5 ">
            <a href="MNU001.jsp"><h3>Student Registration</h3></a>
        </div>  
        <div class="col-md-6">
            <p>Admin: USR${sessionScope.user.id} ${sessionScope.user.name}</p>
            <p>Current Date : <%
						  Date currentDate = new Date();
						  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
						  String formattedDate = formatter.format(currentDate);
						  out.println(formattedDate);
						%></p>
        </div>  
        <div class="col-md-1" >
            <input type="button" class="btn-basic" id="lgnout-button" value="Log Out" onclick="location.href='LoginServlet'">
        </div>        
    </div>
</div>

</div>
    <!-- <div id="testsidebar">Hello World </div> -->
    <div class="sidenav">
        
        <button class="dropdown-btn" > Class Management <i class="fa fa-caret-down"></i></button>
        
         <div class="dropdown-container">
          <a href="BUD003.jsp">Course Registration </a>
          <a href="BUD003-01.jsp">Course Management</a>
          <a href="STU001.jsp">Student Registration </a>
          <a href="STU003.jsp">Student Search </a>
        </div>
        <a href="USR003.jsp">Users Management</a>
      </div>

  		
        <script>
            /* Loop through all dropdown buttons to toggle between hiding and showing its dropdown content - This allows the user to have multiple dropdowns without any conflict */
            var dropdown = document.getElementsByClassName("dropdown-btn");
            var i;
            
            for (i = 0; i < dropdown.length; i++) {
              dropdown[i].addEventListener("click", function() {
              this.classList.toggle("active");
              var dropdownContent = this.nextElementSibling;
              if (dropdownContent.style.display === "block") {
              dropdownContent.style.display = "none";
              } else {
              dropdownContent.style.display = "block";
              }
              });
            }
            </script>

