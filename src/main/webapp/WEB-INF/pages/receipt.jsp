<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Roboto:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

        <!-- Vendor CSS Files -->
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet" />
        <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet" />
        <link href="assets/vendor/quill/quill.snow.css" rel="stylesheet" />
        <link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet" />
        <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet" />
        <link href="assets/vendor/simple-datatables/style.css" rel="stylesheet" />

        <!-- Template Main CSS File -->
        <link href="assets/css/style.css" rel="stylesheet" />

    </head>
    <body style='background-color:  #f6f9fe'>
        <main class="main d-flex align-items-center">
            <div class="container">
                <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">
                                <div class="d-flex justify-content-center py-4">
                                    <h1><span class="d-none d-lg-block">${receipt.getTitle()}</span></h1>
                                </div>

                                <c:if test="${receipt.getId() != null}">
                                    <h3><span class="d-none d-lg-block">ID: ${receipt.getId()}</span></h3>
                                </c:if>

                                <c:if test="${receipt.getDate() != null}">
                                    <h3><span class="d-none d-lg-block">Date: ${receipt.getDate()}</span></h3>
                                </c:if>
                                
                                <c:if test="${receipt.getReceiptType() == complex}">
                                    <c:if test="${receipt.getCashier() != null}">
                                        <h3><span class="d-none d-lg-block">Cashier: ${receipt.getCashier().getUsername()}</span></h3>
                                    </c:if>
                                </c:if>

                                <c:if test="${paymentType != null}">
                                    <h3><span class="d-none d-lg-block">Payment type: ${paymentType}</span></h3>
                                </c:if>

                                <c:if test="${receipt.getProducts() == null}">
                                    <div class="alert alert-warning" role="alert">
                                        The cart is empty!
                                    </div>
                                </c:if>
                                <c:if test="${receipt.getProducts() != null}">
                                    <table class="table">
                                        <tr>
                                            <th scope="col"></th>
                                            <th scope="col">Name</th>
                                            <th scope="col">Price</th>
                                        </tr>
                                        <c:forEach var="product" items="${receipt.getProducts()}">
                                            <tr>
                                                <td>${product.imgPath}</td>
                                                <td>${product.productName}</td>
                                                <td>${product.price}</td>
                                            </tr>
                                        </c:forEach>

                                        <tr>
                                            <td></td>
                                            <td>TOTAL</td>
                                            <td>${receipt.getTotalAmount()}</td>
                                        </tr>

                                        <c:if test="${receipt.getTaxesAmount() != null}">
                                            <td></td>
                                            <td>TAXES</td>
                                            <td>${receipt.getTaxesAmount()}</td>
                                        </c:if>
                                    </table>

                                    <form method="post" action="/TheFinalPOS/View">
                                        <input type="text" name="userId" value="${receipt.getCashier().getId()}" style="visibility: collapse;position: absolute" />
                                        <div class="col-12">
                                            <button class="btn btn-primary w-100" type="submit">Back</button>
                                        </div>
                                    </form>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </main>

        <div id="preloader"></div>
        <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

        <!-- Vendor JS Files -->
        <script src="assets/vendor/apexcharts/apexcharts.min.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/vendor/chart.js/chart.min.js"></script>
        <script src="assets/vendor/echarts/echarts.min.js"></script>
        <script src="assets/vendor/quill/quill.min.js"></script>
        <script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
        <script src="assets/vendor/tinymce/tinymce.min.js"></script>
        <script src="assets/vendor/php-email-form/validate.js"></script>

        <!-- Template Main JS File -->
        <script src="assets/js/main.js"></script>
    </body>
</html>
