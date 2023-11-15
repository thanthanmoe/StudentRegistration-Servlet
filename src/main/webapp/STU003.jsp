<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="dao.*,models.*,java.util.*"%>
<%@ include file="header.jsp"%>
    
        <title>Student Search</title>
</head>

<body>
<%@ include file="navbar.jsp"%>
      <div class="main_contents">
    <div id="sub_content">
      <form class="row g-3 mt-3 ms-2" action="StudentSearchServlet" method="post">
      <h3 style="color: red">${error }</h3>
        <div class="col-auto">
          <label for="staticEmail2" class="visually-hidden">studentID</label>
          <input type="text"  class="form-control" id="staticEmail2" placeholder="Student ID" name="studentId">
        </div>
        <div class="col-auto">
          <label for="inputPassword2" class="visually-hidden">studentName</label>
          <input type="text" class="form-control" id="inputPassword2" placeholder="Student Name" name="name">
        </div>
        <div class="col-auto">
            <label for="inputPassword2" class="visually-hidden">Course</label>
            <input type="text" class="form-control" id="inputPassword2" placeholder="Course" name="attend">
          </div>
        <div class="col-auto">
          <button type="submit" class="btn btn-success mb-3" >Search</button>
        </div>
        
        <div class="col-auto">
          <button type="reset" class="btn btn-secondary mb-3">Reset</button>
        </div>
      </form>
<div>
<c:if test="${list!=null }">
      <table class="table table-striped" id="stduentTable">
        <thead>
          
          <tr>
            <th scope="col">#</th>
            <th scope="col">Student ID</th>
            <th scope="col">Name</th>
            <th scope="col">Course Name</th>
             <th scope="col">Photo</th>
            <th scope="col">Details</th>
          </tr>
          
        </thead>
        <tbody>
	        <c:forEach  items="${list}" var="u" varStatus="status">
	          <tr>
	           <td>${status.index+1}</td>
				<td>STU${u.getStudentId()}</td>
				<td>${u.getName()}</td>
				<td>${u.getAttend()}</td>
				<td><img src="image/${u.getPhoto()}" alt="..." style="width: 80px;height: 60px"> </td>
				<td>
	              <a href="StudentSearchServlet?studentId=${u.getStudentId()}" class="btn btn-secondary mb-2">See More</a> 
	            </td>
	           </tr>
	         </c:forEach>
          
         
          
        </tbody>
      </table>
      </c:if>
    </div>
</div>
</div>
 <%@ include file="footer.jsp"%>      