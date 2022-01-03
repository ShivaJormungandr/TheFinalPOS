<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta content="width=device-width, initial-scale=1.0" name="viewport" />

        <title>Dashboard - NiceAdmin Bootstrap Template</title>
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
        </main>
        <footer id="footer" class="footer">
            <div class="copyright">
                &copy; Copyright <strong><span>The Final POS</span></strong
                >. All Rights Reserved
            </div>
            <div class="credits">
                Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
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

        <script src="assets/js/main.js"></script>
    </body>
</html>

