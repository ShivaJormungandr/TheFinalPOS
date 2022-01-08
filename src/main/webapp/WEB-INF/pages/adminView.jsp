<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta content="width=device-width, initial-scale=1.0" name="viewport" />

        <title>Admin</title>
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

    <body>
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
                        <button type="button" class="btn btn-primary" onclick="location.href = '/TheFinalPOS/Register?loggedUserId=${loggedUser.id}'"><i class="bi bi-collection"></i> Register account</button>
                    </li>
                    <li class="nav-item">
                        <button type="button" class="btn btn-primary" onclick="location.href = '/TheFinalPOS/AddProduct?loggedUserId=${loggedUser.id}'"><i class="bi bi-collection"></i> Add Product</button>
                    </li>
                    <li class="nav-item">
                        <button type="button" class="btn btn-primary" onclick="location.href = '/TheFinalPOS/AddCategory?loggedUserId=${loggedUser.id}'"><i class="bi bi-collection"></i> Add Category</button>
                    </li>
                    <li class="nav-item dropdown pe-3">
                        <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
                            <span class="d-none d-md-block dropdown-toggle ps-2">${loggedUser.getFullname()}</span>
                        </a><!-- End Profile Iamge Icon -->

                        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
                            <li class="dropdown-header">
                                <h6>${loggedUser.getFullname()}</h6>
                                <span>${loggedUser.getIdRole()}</span>
                            </li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li>
                                <a class="dropdown-item d-flex align-items-center" onclick="location.href = '/TheFinalPOS/Logout?loggedUserId=${loggedUser.getId()}'">
                                    <i class="bi bi-box-arrow-right"></i>
                                    <span>Sign Out</span>
                                </a>
                            </li>

                        </ul><!-- End Profile Dropdown Items -->
                    </li><!-- End Profile Nav -->

                </ul>
            </nav><!-- End Icons Navigation -->
        </header>
        <main id="main" class="main">
            <section class="section dashboard">
                <div class="row">
                    <!-- Left side columns -->
                    <div class="col-lg-10">
                        <div class="row">
                            <!-- Recent Sales -->
                            <div class="col-12">
                                <div class="card recent-sales">
                                    <div class="card-body">
                                        <div class="card-body">
                                            <h5 class="card-title">Dashboard</h5>
                                            <ul class="nav nav-tabs nav-tabs-bordered d-flex" id="borderedTabJustified" role="tablist">
                                                <li class="nav-item flex-fill" role="presentation">
                                                    <button class="nav-link w-100 active" id="home-tab" data-bs-toggle="tab" data-bs-target="#bordered-justified-users" type="button" role="tab" aria-controls="home" aria-selected="true">Users</button>
                                                </li>
                                                <li class="nav-item flex-fill" role="presentation">
                                                    <button class="nav-link w-100" id="profile-tab" data-bs-toggle="tab" data-bs-target="#bordered-justified-products" type="button" role="tab" aria-controls="profile" aria-selected="false">Products</button>
                                                </li>
                                                <li class="nav-item flex-fill" role="presentation">
                                                    <button class="nav-link w-100" id="contact-tab" data-bs-toggle="tab" data-bs-target="#bordered-justified-categories" type="button" role="tab" aria-controls="contact" aria-selected="false">Categories</button>
                                                </li>
                                            </ul>
                                            <div class="tab-content pt-2" id="borderedTabJustifiedContent">
                                                <div class="tab-pane fade show active" id="bordered-justified-users" role="tabpanel" aria-labelledby="users-tab">
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
                                                                        <th scope="col"></th>
                                                                        <th scope="col"></th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <c:set var="i" value="1" scope="page" />
                                                                    <c:forEach var="user" items="${allUsers}">
                                                                        <c:if test="${user.idState == 'Accepted'}">
                                                                            <tr>
                                                                                <th>${user.id}</th>
                                                                                <td>${user.fullname}</td>
                                                                                <td>${user.username}</td>
                                                                                <td>${user.email}</td>
                                                                                <td>${user.getIdRole()}</td>
                                                                                <td>
                                                                                    <span class="badge bg-success">${user.idState}</span>
                                                                                </td>
                                                                                <td>
                                                                                    <button type="button" data-bs-toggle="modal" data-bs-target="#verticalycenteredA">❌</button>
                                                                                    <div class="modal fade" id="verticalycenteredA" tabindex="-1">
                                                                                        <div class="modal-dialog modal-dialog-centered">
                                                                                            <div class="modal-content">
                                                                                                <div class="modal-header">
                                                                                                    <h5 class="modal-title">Delete User</h5>
                                                                                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                                                </div>
                                                                                                <div class="modal-body">
                                                                                                    Are you sure you want to delete ${user.fullname}?
                                                                                                </div>
                                                                                                <div class="modal-footer">
                                                                                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                                                                    <button type="button" class="btn btn-primary" onclick="location.href = '/TheFinalPOS/DeleteUser?id=${user.id}&loggedUserId=${loggedUser.getId()}'">Delete</button>
                                                                                                </div>
                                                                                            </div>
                                                                                        </div>
                                                                                    </div>
                                                                                </td>
                                                                                <td>
                                                                                    <button type="button" onclick="location.href = '/TheFinalPOS/EditUser?userId=${user.id}&loggedUserId=${loggedUser.getId()}'">🖍️️</button>
                                                                                </td>
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
                                                                                        <button type="button" data-bs-toggle="modal" data-bs-target="#verticalycenteredP">Delete</button>
                                                                                        <div class="modal fade" id="verticalycenteredP" tabindex="-1">
                                                                                            <div class="modal-dialog modal-dialog-centered">
                                                                                                <div class="modal-content">
                                                                                                    <div class="modal-header">
                                                                                                        <h5 class="modal-title">Delete User</h5>
                                                                                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                                                    </div>
                                                                                                    <div class="modal-body">
                                                                                                        Are you sure you want to delete ${user.fullname}?
                                                                                                    </div>
                                                                                                    <div class="modal-footer">
                                                                                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                                                                        <button type="button" class="btn btn-primary" onclick="location.href = '/TheFinalPOS/DeleteUser?id=${user.getId()}&loggedUserId=${loggedUser.id}'">Delete</button>
                                                                                                    </div>
                                                                                                </div>
                                                                                            </div>
                                                                                        </div>
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
                                                <div class="tab-pane fade" id="bordered-justified-products" role="tabpanel" aria-labelledby="products-tab">
                                                    <div class="tab-content pt-2" id="borderedTabJustifiedContent">
                                                        <table class="table datatable">
                                                            <thead>
                                                                <tr>
                                                                    <th scope="col">#</th>
                                                                    <th scope="col">Image</th>
                                                                    <th scope="col">Name</th>
                                                                    <th scope="col">Price</th>
                                                                    <th></th>
                                                                    <th></th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <c:set var="i" value="1" scope="page" />
                                                                <c:forEach var="product" items="${allProducts}">
                                                                    <tr>
                                                                        <th scope="row">${i}</th>
                                                                        <td>${product.imgPath}</td>
                                                                        <td>${product.productName}</td>
                                                                        <td>${product.price}</td>
                                                                        <td>
                                                                            <button type="button" data-bs-toggle="modal" data-bs-target="#verticalycenteredP">❌</button>
                                                                            <div class="modal fade" id="verticalycenteredP" tabindex="-1">
                                                                                <div class="modal-dialog modal-dialog-centered">
                                                                                    <div class="modal-content">
                                                                                        <div class="modal-header">
                                                                                            <h5 class="modal-title">Delete Product</h5>
                                                                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                                        </div>
                                                                                        <div class="modal-body">
                                                                                            Are you sure you want to delete ${product.getProductName()}?
                                                                                        </div>
                                                                                        <div class="modal-footer">
                                                                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                                                            <button type="button" class="btn btn-primary" onclick="location.href = '/TheFinalPOS/DeleteProduct?id=${product.getId()}&loggedUserId=${loggedUser.id}'">Delete</button>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </td>
                                                                        <td>
                                                                            <button type="button" onclick="location.href = '/TheFinalPOS/EditProduct?productId=${product.getId()}&loggedUserId=${loggedUser.id}'">🖍️️</button>
                                                                        </td>
                                                                    </tr>
                                                                    <c:set var="i" value="${i + 1}" scope="page"/>
                                                                </c:forEach>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                                <div class="tab-pane fade" id="bordered-justified-categories" role="tabpanel" aria-labelledby="categories-tab">
                                                    <div class="tab-content pt-2" id="borderedTabJustifiedContent">
                                                        <table class="table datatable">
                                                            <thead>
                                                                <tr>
                                                                    <th scope="col">#</th>
                                                                    <th scope="col">Name</th>
                                                                    <th></th>
                                                                    <th></th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <c:set var="i" value="1" scope="page" />
                                                                <c:forEach var="category" items="${allCategories}">
                                                                    <tr>
                                                                        <th scope="row">${i}</th>
                                                                        <td>${category.category}</td>
                                                                        <td>
                                                                            <button type="button" data-bs-toggle="modal" data-bs-target="#verticalycenteredC">❌</button>
                                                                            <div class="modal fade" id="verticalycenteredC" tabindex="-1">
                                                                                <div class="modal-dialog modal-dialog-centered">
                                                                                    <div class="modal-content">
                                                                                        <div class="modal-header">
                                                                                            <h5 class="modal-title">Delete Category</h5>
                                                                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                                        </div>
                                                                                        <div class="modal-body">
                                                                                            Are you sure you want to delete ${category.getCategory()}?
                                                                                        </div>
                                                                                        <div class="modal-footer">
                                                                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                                                            <button type="button" class="btn btn-primary" onclick="location.href = '/TheFinalPOS/DeleteCategory?id=${category.getId()}&loggedUserId=${loggedUser.id}'">Delete</button>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </td>
                                                                        <td>
                                                                            <button type="button" onclick="location.href = '/TheFinalPOS/EditCategory?categoryId=${category.getId()}&loggedUserId=${loggedUser.id}'">🖍️️</button>
                                                                        </td>
                                                                    </tr>
                                                                    <c:set var="i" value="${i + 1}" scope="page"/>
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
