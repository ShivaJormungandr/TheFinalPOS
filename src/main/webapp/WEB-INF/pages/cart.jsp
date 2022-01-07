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
                                    <h1><span class="d-none d-lg-block">Cart</span></h1>
                                </div>

                                <c:if test="${productsInCart == null}">
                                    <div class="alert alert-warning" role="alert">
                                        The cart is empty!
                                    </div>
                                </c:if>
                                <c:if test="${productsInCart != null}">
                                    <table class="table">
                                        <tr>
                                            <th scope="col"></th>
                                            <th scope="col">Name</th>
                                            <th scope="col">Price</th>
                                        </tr>
                                        <c:forEach var="product" items="${productsInCart}">
                                            <tr>
                                                <td>${product.imgPath}</td>
                                                <td>${product.productName}</td>
                                                <td>${product.price}</td>
                                            </tr>
                                        </c:forEach>

                                        <tr>
                                            <td></td>
                                            <td>TOTAL</td>
                                            <td>${moneyTotal}</td>
                                        </tr>
                                    </table>

                                    <br> <br>

                                    <form action="/TheFinalPOS/ProcessSale" method="post" class="row g-3">
                                        <div class="col-12">
                                            <p>Please select your receipt type: </p>
                                            <input type="radio" name="receiptType" value="simple" id="receiptType" checked>
                                            <label for="receiptType">Simple</label><br>
                                            <input type="radio" name="receiptType" value="complex" id="receiptType">
                                            <label for="receiptType">Complex</label><br>
                                        </div>

                                        <div class="col-12">
                                            <p>Please select the payment type: </p>
                                            <input type="radio" name="paymentType" value="cash" id="paymentType" checked>
                                            <label for="paymentType">Cash</label><br>
                                            <input type="radio" name="paymentType" value="card" id="paymentType">
                                            <label for="paymentType">Card</label><br>
                                        </div>
                                        
                                        <c:if test="${cartType == 'Rental'}">
                                            <label>Return date: </label>
                                            <input type="date" class="form-control" value="${today}" name="rentalReturnDate" required>
                                        </c:if>

                                        <input type="text" name="cashierId" value="${cashierId}" style="visibility: collapse;position: absolute" />
                                        <input type="text" name="cartType" value="${cartType}" style="visibility: collapse;position: absolute" />

                                        <div class="col-12">
                                            <button class="btn btn-primary w-100" type="submit">Proceed to buy</button>
                                        </div>
                                        
                                        <div class="col-12">
                                            <a href="http://localhost:8080/TheFinalPOS/ShowCategories?action=${cartType}&cashierId=${cashierId}"><button class="btn btn-primary w-100" type="button">Back</button></a>
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
