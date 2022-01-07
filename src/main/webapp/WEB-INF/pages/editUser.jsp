<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Edit User</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="${pageContext.request.contextPath}/assets/img/favicon.png" rel="icon">
  <link href="${pageContext.request.contextPath}/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.gstatic.com" rel="preconnect">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="${pageContext.request.contextPath}/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/vendor/quill/quill.snow.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/vendor/quill/quill.bubble.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/vendor/simple-datatables/style.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet">
</head>

<body>

  <main>
    <div class="container">
      <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">

              <div class="d-flex justify-content-center py-4">
                <a href="index.jsp" class="logo d-flex align-items-center w-auto">
                  <img src="${pageContext.request.contextPath}/assets/img/logo.png" alt="">
                  <span class="d-none d-lg-block">The FinalPOS</span>
                </a>
              </div><!-- End Logo -->

              <div class="card mb-3">

                <div class="card-body">

                  <div class="pt-4 pb-2">
                    <h5 class="card-title text-center pb-0 fs-4">Edit account</h5>
                  </div>

                  <form class="row g-3 needs-validation" novalidate action="/TheFinalPOS/AddUser?action=edit&loggedUserId=${loggedUser.getId()}" method="post">
                      <input value="${loggedUser.getId()}" name="loggedUserId" style="visibility: collapse; position: absolute" />
                      <input value="${user.getId()}" name="userId" style="visibility: collapse; position: absolute" />
                      <div class="col-12">
                      <label for="yourName" class="form-label">Name</label>
                      <input type="text" value="${user.getFullname()}" name="fullname" class="form-control" id="yourName" required>
                    </div>

                    <div class="col-12">
                      <label for="yourEmail" class="form-label">Email</label>
                      <input type="email" value="${user.getEmail()}" name="email" class="form-control" id="yourEmail" required>
                    </div>

                    <div class="col-12">
                      <label for="yourUsername" class="form-label">Username</label>
                      <div class="input-group has-validation">
                        <input type="text" value="${user.getUsername()}" name="username" class="form-control" id="yourUsername" required>
                        <div class="invalid-feedback">Please choose a username.</div>
                      </div>
                      <c:if test="${err_msg_user != null}">
                          <div style="color: #bb2d3b">${err_msg_user}</div>
                      </c:if>
                    </div>

                    <div class="col-12">
                      <label for="yourPassword" class="form-label">Password</label>
                      <input type="password" value="******" name="password" class="form-control" id="yourPassword" required>
                      <div class="invalid-feedback">Passwords do not match!</div>
                      <c:if test="${err_msg_pass != null}">
                          <div style="color: #bb2d3b">${err_msg_pass}</div>
                      </c:if>
                    </div>
                      
                    <div class="col-12">
                      <label for="yourRetypePassword" class="form-label">Retype Password</label>
                      <input type="password" value="******" name="retypePass" class="form-control" id="yourRetypePassword" required>
                    </div>
                      
                    <div class="col-12">
                      <label for="yourPassword" class="form-label">Role</label>
                      <select name="role" class="form-control" id="yourRole" required>
                          <c:forEach var="role" items="${roles}">
                              <option value="${role.getRole()}">${role.getRole()}</option>
                          </c:forEach>
                      </select>
                    </div>

                    <div class="col-12">
                      <button class="btn btn-primary w-100" type="submit">Edit Account</button>
                    </div>
                  </form>

                </div>
              </div>

              <div class="credits">
                Designed by <a href="https://www.youtube.com/watch?v=dQw4w9WgXcQ">Me</a>
              </div>

            </div>
          </div>
        </div>

      </section>

    </div>
  </main><!-- End #main -->

  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="${pageContext.request.contextPath}/assets/vendor/apexcharts/apexcharts.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/vendor/chart.js/chart.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/vendor/echarts/echarts.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/vendor/quill/quill.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/vendor/simple-datatables/simple-datatables.js"></script>
  <script src="${pageContext.request.contextPath}/assets/vendor/tinymce/tinymce.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="${pageContext.request.contextPath}/assets/js/main.js"></script>

</body>

</html>