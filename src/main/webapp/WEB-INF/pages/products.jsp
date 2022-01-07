<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>All products</title>
        <meta content="" name="description">
        <meta content="" name="keywords">

        <!-- Favicons -->
        <link href="assets/img/favicon.png" rel="icon">
        <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Google Fonts -->
        <link href="https://fonts.gstatic.com" rel="preconnect">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

        <!-- Vendor CSS Files -->
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
        <link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
        <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">

        <!-- Template Main CSS File -->
        <link href="assets/css/style.css" rel="stylesheet">

    </head>

    <body class="toggle-sidebar">

        <!-- ======= Header ======= -->
        <header id="header" class="header fixed-top d-flex align-items-center">

            <div class="d-flex align-items-center justify-content-between">
                <a href="index.jsp" class="logo d-flex align-items-center">
                    <img src="assets/img/logo.png" alt="">
                    <span class="d-none d-lg-block">The FinalPOS</span>
                </a>
            </div><!-- End Logo -->
        </header><!-- End Header -->

        <main id="main" class="main">

            <section class="section">
                <div class="row">
                    <div class="col-lg-12">

                        <div class="card dashboard">
                            <div class="card-body">
                                <h5 class="card-title">Products</h5>
                                <table class="table datatable">
                                    <thead>
                                        <tr>
                                            <th scope="col">Id</th>
                                            <th scope="col">Image</th>
                                            <th scope="col">Name</th>
                                            <th scope="col">Price</th>
                                            <th scope="col"></th>
                                            <th scope="col">Quantity</th>
                                            <th scope="col"></th>
                                            <th scope="col">Add to cart</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:set var="i" value="1" scope="page" />
                                        <c:forEach var="product" items="${products}">
                                            <tr>
                                                <td>${i}</td>
                                                <td>${product.imgPath}</td>
                                                <td>${product.productName}</td>
                                                <td>${product.price}</td>
                                                <td><input type="button" id='subtractQty' value="➖" onclick='subtractQuantity(${i})' /> </td>
                                                <td><input type='textbox' name="quantity" value='0' id='tbQuantity${i}'/> </td>
                                                <td><input type="button" id='addQty' value="➕" onclick='increaseQuantity(${i})' /></td>
                                            <input style="visibility: collapse" name="productId" value="${product.id}" />
                                            <td><input type="button" onclick='addToCart(${i},${product.id}, ${cashierId})' value="🛒" id='addToCart' /></td>

                                            <c:set var="i" value="${i + 1}" scope="page"/>
                                            </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>

                    </div>
                </div>
            </section>

        </main><!-- End #main -->

        <!-- ======= Footer ======= -->
        <footer id="footer" class="footer">
            <div class="copyright">
                &copy; Copyright <strong><span>The Final POS</span></strong>. All Rights Reserved
            </div>
        </footer><!-- End Footer -->

        <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

        <!-- Vendor JS Files -->
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/vendor/chart.js/chart.min.js"></script>
        <script src="assets/vendor/echarts/echarts.min.js"></script>
        <script src="assets/vendor/quill/quill.min.js"></script>
        <script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
        <script src="assets/vendor/tinymce/tinymce.min.js"></script>

        <!-- Template Main JS File -->
        <script src="assets/js/main.js"></script>
        <script type='text/javascript'>
            function increaseQuantity(id) {
                    let tb = document.getElementById('tbQuantity' + id);
                    let qty = parseInt(tb.value);
                    qty++;
                    tb.value = qty;
                }
                function subtractQuantity(id) {
                    let tb = document.getElementById('tbQuantity' + id);
                    let qty = parseInt(tb.value);
                    if (qty > 0)
                        qty--;
                    tb.value = qty;
                }
                function addToCart(index,productId, cashierId) {
                    let quantity = document.getElementById('tbQuantity' + index).value;
                    location.href = '/TheFinalPOS/ShowCart?productId='+ productId + '&quantity=' + quantity + '&cashierId=' + cashierId;
                }
        </script>
    </body>

</html>
