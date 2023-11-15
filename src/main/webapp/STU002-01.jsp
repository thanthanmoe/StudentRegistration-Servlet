<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="dao.*,models.*,java.util.*"%>
<%@ include file="header.jsp"%>
    
        <title>Student Delete and Update</title>
</head>

<body>
<%@ include file="navbar.jsp"%>
<%
CourseDao cdao = new CourseDao();
	List<CourseRegistration> srs=cdao.allCourse();
	request.setAttribute("list", srs);
%>
		<div class="main_contents">
    		<div id="sub_content">
         <form action="StudentUpdateServlet" method="post" enctype="multipart/form-data" onsubmit="return validateForm()">

            <h2 class="col-md-6 offset-md-2 mb-5 mt-4">Student Update</h2>
            <h4 class="col-md-6 offset-md-2 mb-2 mt-2" style="color: red;">${error }</h4>
            <h4 class="col-md-6 offset-md-2 mb-2 mt-2" style="color: green;">${success }</h4>
           <c:forEach items="${srs }" var="u">
            <div class="row mb-4">
                <div class="col-md-2"></div>
              
                <div class="col-md-4">
                    <input type="hidden" class="form-control"  name="studentId" id="studentId" value="${u.studentId }" readonly="readonly">
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="name" class="col-md-2 col-form-label">Name</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" id="name" name="name" value="${u.name }">
                </div>
                 <div id="nameError" class="col-md-4" style="color: red;"></div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="dob" class="col-md-2 col-form-label">DOB</label>
                <div class="col-md-4">
                    <input type="date" class="form-control" id="dob" name="date" value="${u.date}">
                </div>
                 <div id="dateError" class="col-md-4" style="color: red;"></div>
            </div>
            <fieldset class="row mb-4">
                <div class="col-md-2"></div>
                <legend class="col-form-label col-md-2 pt-0">Gender</legend>
                <div class="col-md-4">
                    <div class="form-check-inline">
                        <input <c:if test="${u.gender=='male' }">checked</c:if> class="form-check-input" type="radio" name="gender" id="gridRadios1" value="male"
                            >
                        <label class="form-check-label" for="gridRadios1">
                            Male
                        </label>
                    </div>
                    <div class="form-check-inline">
                        <input <c:if test="${u.gender=='female' }">checked</c:if> class="form-check-input" type="radio" name="gender" id="attend" value="female">
                        <label class="form-check-label" for="gridRadios2">
                            Female
                        </label>
                    </div>
				</div>
				 <div id="genderError" class="col-md-4" style="color: red;"></div>
            </fieldset>
    
            <div class="row mb-4" >
                <div class="col-md-2"></div>
                <label for="phone" class="col-md-2 col-form-label">Phone</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" id="phone" name="phone" value="${u.phone }">
                </div>
                 <div id="phoneError" class="col-md-4" style="color: red;"></div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="education" class="col-md-2 col-form-label">Education</label>
                <div class="col-md-4">
                    <select class="form-select" aria-label="Education" id="education" name="education">
                        <option <c:if test="${u.education=='Bachelor of Information Technology' }">selected</c:if> value="Bachelor of Information Technology">Bachelor of Information Technology</option>
                        <option <c:if test="${u.education=='Diploma in IT' }">selected</c:if> value="Diploma in IT">Diploma in IT</option>
                        <option <c:if test="${u.education=='Bachelor of Computer Science' }">selected</c:if> value="Bachelor of Computer Science">Bachelor of Computer Science</option>
    
                    </select>
                </div>
            </div>
             <fieldset class="row mb-4">
                <div class="col-md-2"></div>
                <legend class="col-form-label col-md-2 pt-0">Attend</legend>
    
                <div class="col-md-4">
				                    
				     <c:forEach items="${list }" var="list">
				   	 <div class="form-check-inline col-md-3">
				                        <input  class="form-check-input"  <c:forEach var="substring" items="${u.attend.split(',')}"> <c:if test="${substring==list.course_name  }">checked</c:if> 	</c:forEach> type="checkbox" id="attend" name="attend" id="gridRadios2" value="${list.course_name }"  multiple="multiple">
				                        <label class="form-check-label" for="gridRadios2">
				                           ${list.course_name }
				                        </label>
				                    </div>
				    </c:forEach>
                </div>
                
             <div id="attendError" class="col-md-4" style="color: red;"></div>
            </fieldset>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="name" class="col-md-2 col-form-label">Photo</label>
                <div class="col-md-4">
                    <input type="file" class="form-control" id="part" name="part" value="${u.photo }">
                </div>
                 <div id="partError" class="col-md-4" style="color: red;"></div>
            </div>
    </c:forEach>
            <div class="row mb-4">
                <div class="col-md-4"></div>
    
                <div class="col-md-4">
                    <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#exampleModal">
                        Update
                    </button>
               
                    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                    aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Student Update</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                               
                               <h5 style="color: rgb(127, 209, 131);">Are yo sure want to Update!</h5>
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary" data-bs-dismiss="modal">Ok</button>
                               
                            </div>
                        </div>
                    </div>
            </div>
               
    
            <button type="button" class="btn btn-danger  " onclick="location.href = 'STU003.jsp';">
                Cancel
            </button>
    
                </div>
    
            </div>
    
    
            <!--Modal-->
    
            </form>
    </div>
</div>
<script>
    function validateForm() {
      /*   var studentId = document.getElementById("studentId").value; */
        var name = document.getElementById("name").value;
        var date = document.getElementById("date").value;
        var gender = document.querySelector('input[name="gender"]:checked');
        var phone = document.getElementById("phone").value;
        var education = document.getElementById("education").value;
        var attend = document.querySelectorAll('input[name="attend"]:checked');
        var part = document.getElementById("part").value;
  
            // Validate studentId
            /* if (studentId== "") {

            	document.getElementById("studentIdError").innerHTML = "Please enter Student ID";
                return false;
            } */
            
           

	/// Validate name
		if (name== "") {
			document.getElementById("nameError").innerHTML = "Please enter Name";
			return false;
		}

		// Validate date
		if (date== "") {
			document.getElementById("dateError").innerText = "Please enter Date ";
			return false;
		}

		// Validate gender
		if (!gender) {
			document.getElementById("genderError").innerText = "Please select Gender";
			return false;
		}

		// Validate phone
		if (phone== "") {
			document.getElementById("phoneError").innerText = "Please enter Phone";
			return false;
		}else if (!isValidPhone(phone)) {
			document.getElementById("phoneError").innerHTML = "Phone No is invalid !!!";
            isValid = false;
          }

		// Validate education
		if (education== "") {
			document.getElementById("educationError").innerText = "Please select Education";
			return false;
		}
		if (part== "") {
			document.getElementById("partError").innerText = "Select photo";
			return false;
		}
		 function isValidPhone(phone){
	        	var phoneRegex=/[0]{1}[1,2,9]{1}[0-9]{9}/;
	        		return phoneRegex.test(phone);
	        }
		// Validate attend
		if (attend.length === 0) {
			document.getElementById("attendError").innerText = "Select at least one";
			return false;
		}

		document.getElementById("attendError").innerText = "";
		return true;
	}
    
    
</script>
<%@ include file="footer.jsp"%>