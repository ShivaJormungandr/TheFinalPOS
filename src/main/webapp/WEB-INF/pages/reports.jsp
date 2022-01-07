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
                    <li class="nav-item">
                        <!-- <button type="button" class="btn btn-primary" onclick="location.href = '/TheFinalPOS/View'"><i class="bi bi-collection"></i> Users</button> -->
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
                            <i class="bi bi-bell"></i>
                            <span class="badge bg-primary badge-number">${notificationCount}</span>
                        </a><!-- End Notification Icon -->

                        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow notifications">
                            <li class="dropdown-header">
                                You have ${notificationCount} new notifications
                            </li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>

                            <c:forEach begin="1" end="${notificationCount}">
                                <li class="notification-item">
                                    <i class="bi bi-exclamation-circle text-warning"></i>
                                    <div>
                                        <h4>New User!</h4>
                                        <p>${notificationMessage.message}</p>
                                    </div>
                                </li>

                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                            </c:forEach>

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
                            <div class="card">
                                <div class="card-body">
                                    <!-- View All Transactions -->
                                    <form class="row g-3" novalidate action="/TheFinalPOS/Reports" method="post">
                                        <h5 class="card-title">View All Transactions</h5>
                                        <div class="col-12" >
                                            <input type="hidden" name="report" class="form-control" id="report" value="all">
                                        </div>
                                        <div class="row mb-3" >
                                            <div class="col-sm-10">
                                                <button type="submit" class="btn btn-primary">View</button>
                                            </div>
                                        </div>
                                    </form>
                                    <!-- View All Transactions -->
                                </div>
                            </div>
                            
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title">View Transactions Between Values</h5>
                                    <!-- No Labels Form -->
                                    <form class="row g-3 needs-validation" novalidate action="/TheFinalPOS/Reports" method="post">
                                        <div class="col-md-12">
                                            <input type="hidden" class="form-control" name="report" class="form-control" id="report" value="values">
                                        </div>
                                        <div class="col-md-6">
                                            <input type="text" class="form-control" name="fromValue" placeholder="From" required>
                                        </div>
                                        <div class="col-md-6">
                                            <input type="text" class="form-control" name="toValue" placeholder="To" required>
                                        </div>
                                        <div class="text-center">
                                            <button type="submit" class="btn btn-primary">View</button>
                                        </div>
                                    </form>
                                    <!-- End No Labels Form -->
                                </div>
                            </div>
                            
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title">View Transactions Between Dates</h5>
                                    <!-- No Labels Form -->
                                    <form class="row g-3 needs-validation" novalidate action="/TheFinalPOS/Reports" method="post">
                                        <div class="col-md-12">
                                            <input type="hidden" class="form-control" name="report" class="form-control" id="report" value="dates">
                                        </div>
                                        <div class="col-md-6">
                                            <input type="date" class="form-control" name="fromDate" placeholder="From" required>
                                        </div>
                                        <div class="col-md-6">
                                            <input type="date" class="form-control" name="toDate" placeholder="To" required>
                                        </div>
                                        <div class="text-center">
                                            <button type="submit" class="btn btn-primary">View</button>
                                        </div>
                                    </form>
                                    <!-- End No Labels Form -->
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

