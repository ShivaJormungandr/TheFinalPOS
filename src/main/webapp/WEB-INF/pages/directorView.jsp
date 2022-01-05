<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta content="width=device-width, initial-scale=1.0" name="viewport" />

        <title>Director</title>
        <meta content="" name="description" />
        <meta content="" name="keywords" />

        <!-- Favicons -->
        <link href="assets/img/favicon.png" rel="icon" />
        <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon" />

        <!-- Google Fonts -->
        <link href="https://fonts.gstatic.com" rel="preconnect" />
        <link
            href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
            rel="stylesheet"
            />

        <!-- Vendor CSS Files -->
        <link
            href="assets/vendor/bootstrap/css/bootstrap.min.css"
            rel="stylesheet"
            />
        <link
            href="assets/vendor/bootstrap-icons/bootstrap-icons.css"
            rel="stylesheet"
            />
        <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet" />
        <link href="assets/vendor/quill/quill.snow.css" rel="stylesheet" />
        <link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet" />
        <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet" />
        <link href="assets/vendor/simple-datatables/style.css" rel="stylesheet" />

        <!-- Template Main CSS File -->
        <link href="assets/css/style.css" rel="stylesheet" />
    </head>

    <body class="toggle-sidebar toggle-">
   <!-- Nav Bar -->
   <header id="header" class="header fixed-top d-flex align-items-center">

    <div class="d-flex align-items-center justify-content-between">
      <a href="index.jsp" class="logo d-flex align-items-center">
        <img src="assets/img/logo.png" alt="">
        <span class="d-none d-lg-block">The Final POS</span>
      </a>
    </div><!-- End Logo -->
    <nav class="header-nav ms-auto">
      <ul class="d-flex align-items-center">
        <li class="nav-item">
            <button type="button" class="btn btn-primary" onclick="location.href = '/TheFinalPOS/AddProduct'"><i class="bi bi-collection"></i> Add Product</button>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
            <i class="bi bi-bell"></i>
            <span class="badge bg-primary badge-number">4</span>
          </a><!-- End Notification Icon -->

          <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow notifications">
            <li class="dropdown-header">
              You have 4 new notifications
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>

            <li class="notification-item">
              <i class="bi bi-exclamation-circle text-warning"></i>
              <div>
                <h4>Lorem Ipsum</h4>
                <p>Quae dolorem earum veritatis oditseno</p>
                <p>30 min. ago</p>
              </div>
            </li>

            <li>
              <hr class="dropdown-divider">
            </li>

            <li class="notification-item">
              <i class="bi bi-x-circle text-danger"></i>
              <div>
                <h4>Atque rerum nesciunt</h4>
                <p>Quae dolorem earum veritatis oditseno</p>
                <p>1 hr. ago</p>
              </div>
            </li>

            <li>
              <hr class="dropdown-divider">
            </li>

            <li class="notification-item">
              <i class="bi bi-check-circle text-success"></i>
              <div>
                <h4>Sit rerum fuga</h4>
                <p>Quae dolorem earum veritatis oditseno</p>
                <p>2 hrs. ago</p>
              </div>
            </li>

            <li>
              <hr class="dropdown-divider">
            </li>

            <li class="notification-item">
              <i class="bi bi-info-circle text-primary"></i>
              <div>
                <h4>Dicta reprehenderit</h4>
                <p>Quae dolorem earum veritatis oditseno</p>
                <p>4 hrs. ago</p>
              </div>
            </li>

            <li>
              <hr class="dropdown-divider">
            </li>
          </ul><!-- End Notification Dropdown Items -->

        </li><!-- End Notification Nav -->

        <li class="nav-item dropdown pe-3">

          <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
            <span class="d-none d-md-block dropdown-toggle ps-2">${loggedUser}</span>
          </a><!-- End Profile Iamge Icon -->

          <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
            <li class="dropdown-header">
              <h6>${loggedUser}</h6>
              <span>Director</span>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>
            <li>
              <a class="dropdown-item d-flex align-items-center" onclick="location.href = '/TheFinalPOS/Logout'">
                <i class="bi bi-box-arrow-right"></i>
                <span>Sign Out</span>
              </a>
            </li>

          </ul><!-- End Profile Dropdown Items -->
        </li><!-- End Profile Nav -->

      </ul>
    </nav><!-- End Icons Navigation -->

  </header><!-- End Header -->
        <main id="main" class="main">
            <section class="section dashboard">
                <div class="row">
                    <!-- Left side columns -->
                    <div class="col-lg-8">
                        <div class="row">
                            <!-- Recent Sales -->
                            <div class="col-14">
                                <div class="card recent-sales">
                                    <div class="filter">
                                        <a class="icon" href="#" data-bs-toggle="dropdown"
                                           ><i class="bi bi-three-dots"></i
                                            ></a>
                                        <ul
                                            class="
                                            dropdown-menu dropdown-menu-end dropdown-menu-arrow
                                            "
                                            >
                                            <li class="dropdown-header text-start">
                                                <h6>Filter</h6>
                                            </li>
                                            <li><a class="dropdown-item" href="#">Pending</a></li>
                                            <li><a class="dropdown-item" href="#">Accepted</a></li>
                                            <li><a class="dropdown-item" href="#">Rejected</a></li>
                                        </ul>
                                    </div>
                                    <div class="card-body">
                                        <div class="card-body">
                                            <h5 class="card-title">Users</h5>
                                            <ul class="nav nav-tabs nav-tabs-bordered d-flex" id="borderedTabJustified" role="tablist">
                                                <li class="nav-item flex-fill" role="presentation">
                                                    <button class="nav-link w-100 active" id="home-tab" data-bs-toggle="tab" data-bs-target="#bordered-justified-accepted" type="button" role="tab" aria-controls="home" aria-selected="true">Accepted</button>
                                                </li>
                                                <li class="nav-item flex-fill" role="presentation">
                                                    <button class="nav-link w-100" id="profile-tab" data-bs-toggle="tab" data-bs-target="#bordered-justified-rejected" type="button" role="tab" aria-controls="profile" aria-selected="false">Rejected</button>
                                                </li>
                                                <li class="nav-item flex-fill" role="presentation">
                                                    <button class="nav-link w-100" id="contact-tab" data-bs-toggle="tab" data-bs-target="#bordered-justified-pending" type="button" role="tab" aria-controls="contact" aria-selected="false">Pending</button>
                                                </li>
                                            </ul>
                                            <div class="tab-content pt-2" id="borderedTabJustifiedContent">
                                                <div class="tab-pane fade show active" id="bordered-justified-accepted" role="tabpanel" aria-labelledby="accepted-tab">

                                                    <table class="table table-borderless datatable">
                                                        <thead>
                                                            <tr>
                                                                <th></th>
                                                                <th scope="col">Name</th>
                                                                <th scope="col">Username</th>
                                                                <th scope="col">Email</th>
                                                                <th scope="col">Role</th>
                                                                <th scope="col">Status</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:set var="i" value="1" scope="page" />
                                                            <c:forEach var="user" items="${allUsers}">
                                                                <c:if test="${user.idState == 'Accepted'}">
                                                                    <tr>
                                                                        <th>${i}</th>
                                                                        <td>${user.fullname}</td>
                                                                        <td>${user.username}</td>
                                                                        <td>${user.email}</td>
                                                                        <td>${user.getIdRole()}</td>
                                                                        <c:if test="${user.idState == 'Accepted'}">
                                                                            <td>
                                                                                <span class="badge bg-success">${user.idState}</span>
                                                                            </td>
                                                                        </c:if>
                                                                    </tr>
                                                                    <c:set var="i" value="${i + 1}" scope="page"/>
                                                                </c:if>
                                                            </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>
                                                <div class="tab-pane fade" id="bordered-justified-rejected" role="tabpanel" aria-labelledby="rejected-tab">
                                                    <table class="table table-borderless datatable">
                                                        <thead>
                                                            <tr>
                                                                <th></th>
                                                                <th scope="col">Name</th>
                                                                <th scope="col">Username</th>
                                                                <th scope="col">Email</th>
                                                                <th scope="col">Role</th>
                                                                <th scope="col">Status</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:set var="i" value="1" scope="page" />
                                                            <c:forEach var="user" items="${allUsers}">
                                                                <c:if test="${user.idState == 'Rejected'}">
                                                                    <tr>
                                                                        <th>${i}</th>
                                                                        <td>${user.fullname}</td>
                                                                        <td>${user.username}</td>
                                                                        <td>${user.email}</td>
                                                                        <td>${user.getIdRole()}</td>

                                                                        <c:if test="${user.idState == 'Rejected'}">
                                                                            <td>
                                                                                <span class="badge bg-danger">${user.idState}</span>
                                                                            </td>
                                                                        </c:if>
                                                                    </tr>
                                                                    <c:set var="i" value="${i + 1}" scope="page"/>
                                                                </c:if>
                                                            </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>
                                                <div class="tab-pane fade" id="bordered-justified-pending" role="tabpanel" aria-labelledby="pending-tab">

                                                    <table class="table table-borderless datatable">
                                                        <thead>
                                                            <tr>
                                                                <th></th>
                                                                <th scope="col">Name</th>
                                                                <th scope="col">Username</th>
                                                                <th scope="col">Email</th>
                                                                <th scope="col">Role</th>
                                                                <th scope="col">Status</th>
                                                                <th></th>
                                                                <th></th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:set var="i" value="1" scope="page" />
                                                            <c:forEach var="user" items="${allUsers}">
                                                                <c:if test="${user.idState == 'Pending'}">
                                                                    <tr>
                                                                        <th>${i}</th>
                                                                        <td>${user.fullname}</td>
                                                                        <td>${user.username}</td>
                                                                        <td>${user.email}</td>
                                                                        <td>${user.getIdRole()}</td>
                                                                        <c:if test="${user.idState == 'Pending'}">
                                                                            <td>
                                                                                <span class="badge bg-warning">${user.idState}</span>
                                                                            </td>
                                                                            <td>
                                                                                <button onclick="location.href = '/TheFinalPOS/UpdateUserState?id=${user.id}&action=Accepted'">Accept</button>
                                                                            </td>
                                                                            <td>
                                                                                <button onclick="location.href = '/TheFinalPOS/UpdateUserState?id=${user.id}&action=Rejected'">Reject</button>
                                                                            </td>
                                                                        </c:if>
                                                                    </tr>
                                                                    <c:set var="i" value="${i + 1}" scope="page"/>
                                                                </c:if>
                                                            </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <div class="col-lg-6">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Bar CHart</h5>

                        <!-- Bar Chart -->
                        <canvas id="barChart" style="max-height: 400px;"></canvas>

                        <!-- End Bar CHart -->

                    </div>
                </div>
            </div>

        </main>


        <footer id="footer" class="footer">
            <div class="copyright">
                &copy; Copyright <strong><span>The Final POS</span></strong
                >. All Rights Reserved
            </div>
        </footer>

        <script src="assets/vendor/apexcharts/apexcharts.min.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/vendor/chart.js/chart.min.js"></script>
        <script src="assets/vendor/echarts/echarts.min.js"></script>
        <script src="assets/vendor/quill/quill.min.js"></script>
        <script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
        <script src="assets/vendor/tinymce/tinymce.min.js"></script>
        <script src="assets/vendor/php-email-form/validate.js"></script>

        <script>
            document.addEventListener("DOMContentLoaded", () => {
                new Chart(document.querySelector('#barChart'), {
                    type: 'bar',
                    data: {
                        labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
                        datasets: [{
                                label: 'Bar Chart',
                                data: [65, 59, 80, 81, 56, 55, 40],
                                backgroundColor: [
                                    'rgba(255, 99, 132, 0.2)',
                                    'rgba(255, 159, 64, 0.2)',
                                    'rgba(255, 205, 86, 0.2)',
                                    'rgba(75, 192, 192, 0.2)',
                                    'rgba(54, 162, 235, 0.2)',
                                    'rgba(153, 102, 255, 0.2)',
                                    'rgba(201, 203, 207, 0.2)'
                                ],
                                borderColor: [
                                    'rgb(255, 99, 132)',
                                    'rgb(255, 159, 64)',
                                    'rgb(255, 205, 86)',
                                    'rgb(75, 192, 192)',
                                    'rgb(54, 162, 235)',
                                    'rgb(153, 102, 255)',
                                    'rgb(201, 203, 207)'
                                ],
                                borderWidth: 1
                            }]
                    },
                    options: {
                        scales: {
                            y: {
                                beginAtZero: true
                            }
                        }
                    }
                });
            });
        </script>
        <script src="assets/js/main.js"></script>
    </body>
</html>
