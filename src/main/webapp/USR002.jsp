<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="dao.*,models.*,java.util.*"%>
<%@ include file="header.jsp"%>
        <title>User Update</title>
</head>
<style>
	.input-group {
  position: relative;
}

#togglePasswordIcon,#togglePasswordIcons {
  position: absolute;
  top: 50%;
  right: 10px;
  transform: translateY(-50%);
  cursor: pointer;
}
</style>
<body>
<%@ include file="navbar.jsp"%>
		
    <div class="main_contents">
    <div id="sub_content">
        <form action="UserUpdateServlet" method="post">
        <h2 class="col-md-6 offset-md-2 mb-5 mt-4">User Update</h2>
       <h3 style="color: red" class="col-md-6 offset-md-2 mb-2 mt-2">${error }</h3>
        <h3 style="color: red" class="col-md-6 offset-md-2 mb-2 mt-2">${success }</h3>
        <c:forEach items="${ur}" var="u">
        <div class="row mb-4">
            <div class="col-md-2"></div>
            
            <div class="col-md-4">
                <input type="hidden" class="form-control" id="id"  name="id" value="${u.id}" readonly="readonly">
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-md-2"></div>
            <label for="text" class="col-md-2 col-form-label">User Name</label>
            <div class="col-md-4">
                <input type="text" class="form-control" id="name"  name="name" value="${u.name }">
            </div>
        </div>
       
         <div class="row mb-4">
            <div class="col-md-2"></div>
            <label for="email" class="col-md-2 col-form-label">Email</label>
            <div class="col-md-4">
                <input type="text" class="form-control" id="email" name="email" value="${u.email }">
            </div>
        </div>
        <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="Passowrd" class="col-md-2 col-form-label">Passowrd</label>
					<div class="col-md-4 form-group">
						<div class="input-group">
							<input type="password" class="form-control" id="password"
								name="password" value="${u.password}" required> <i
								class="fa fa-eye-slash" id="togglePasswordIcon"
								onclick="togglePasswordVisibility()"></i>
						</div>
					</div>
				</div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="confirmPassword" class="col-md-2 col-form-label">Confirm Passowrd</label>

					<div class="col-md-4 form-group">
						<div class="input-group">
							<input type="password" class="form-control" id="passwords"
								name="password1" value="${u.password}" required> <i
								class="fa fa-eye-slash" id="togglePasswordIcons"
								onclick="togglePasswordVisibilitys()"></i>
						</div>
					</div>

				</div>
         
        <div class="row mb-4">
            <div class="col-md-2"></div>
            <label for="userRole" class="col-md-2 col-form-label">User Role</label>
            <div class="col-md-4">
                <select class="form-select" aria-label="Education" id="userRole" name="role">
                    <option <c:if test="${u.role=='Admin' }">selected</c:if> value="Admin" >Admin</option>
                    <option <c:if test="${u.role=='User' }">selected</c:if> value="User">User</option>


                </select>
               
            </div>
        </div>
      </c:forEach>
        <div class="row mb-4">
            <div class="col-md-4"></div>

            <div class="col-md-6">
               

                <button type="button" class="btn btn-success col-md-2" data-bs-toggle="modal" data-bs-target="#exampleModal">Update</button>
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                    aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">User Update</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                               
                               <h5 style="color: rgb(127, 209, 131);">Succesfully Updated !</h5>
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-success col-md-2" data-bs-dismiss="modal">Ok</button>
                               
                            </div>
                        </div>
                    </div>
            </div>
            <button type="button" class="btn btn-secondary col-md-2 " onclick="location.href = 'USR003.jsp';">
                Back
            </button>
    
		</div>
        </div>
        </form>
 </div>
 </div>
 <script type="text/javascript">
function togglePasswordVisibility() {
    var passwordInput = document.getElementById("password");
    var toggleIcon = document.getElementById("togglePasswordIcon");

    if (passwordInput.type === "password") {
        passwordInput.type = "text";
        toggleIcon.classList.remove("fa-eye-slash");
        toggleIcon.classList.add("fa-eye");
    } else {
        passwordInput.type = "password";
        toggleIcon.classList.remove("fa-eye");
        toggleIcon.classList.add("fa-eye-slash");
    }
}

function togglePasswordVisibilitys() {
    var passwordInput = document.getElementById("passwords");
    var toggleIcon = document.getElementById("togglePasswordIcons");

    if (passwordInput.type === "password") {
        passwordInput.type = "text";
        toggleIcon.classList.remove("fa-eye-slash");
        toggleIcon.classList.add("fa-eye");
    } else {
        passwordInput.type = "password";
        toggleIcon.classList.remove("fa-eye");
        toggleIcon.classList.add("fa-eye-slash");
    }
}

</script>
 <%@ include file="footer.jsp"%>