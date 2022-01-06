<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cashier view</title>
        <meta content="" name="description">
        <meta content="" name="keywords">

        <!-- Favicons -->
        <link href="${pageContext.request.contextPath}/assets/img/favicon.png" rel="icon">
        <link href="${pageContext.request.contextPath}/assetsLP/img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Roboto:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

        <!-- Vendor CSS Files -->
        <link href="${pageContext.request.contextPath}/assetsLP/vendor/aos/aos.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/assetsLP/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/assetsLP/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/assetsLP/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/assetsLP/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/assetsLP/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

        <!-- Template Main CSS File -->
        <link href="${pageContext.request.contextPath}/assetsLP/css/style.css" rel="stylesheet">

    </head>
    <body style='background-color:  #f6f9fe'>
        <c:if test="${user.getIdRole() != 'Cashier'}">
            <div class="alert alert-warning" role="alert">
                nu esti cashier
            </div>
        </c:if>
        <c:if test="${user.getIdRole() == 'Cashier'}">
            <button style="position: absolute" onclick="location.href = '/TheFinalPOS/Logout'">Logout</button>
            <main id="main">

                <section id="team" class="team section-bg">
                    <div class="container" data-aos="fade-up">

                        <div class="section-title">
                            <h3>Choose an action.</h3>
                        </div>

                        <div class="row">
                            <c:forEach var="type" items="${types}">
                                <div class="col-lg-4 col-md-6 d-flex align-items-stretch" data-aos="fade-up" data-aos-delay="100">
                                    <div class="member">
                                        <c:if test="${type == 'Sale'}" >
                                            <div class="member-img">
                                                <a href="http://localhost:8080/TheFinalPOS/ShowCategories?action=Sale&cashierId=${user.getId()}"><img src="${pageContext.request.contextPath}/assetsLP/img/${type}.jpg" height="300px" width="350px" alt=""></a>
                                            </div>
                                            <div class="member-info">
                                                <h1>${type}</h1>
                                            </div>
                                        </c:if>
                                        <c:if test="${type == 'Rental'}" >
                                            <div class="member-img">
                                                <a href="http://localhost:8080/TheFinalPOS/ShowCategories?action=Rental&cashierId=${user.getId()}"><img src="${pageContext.request.contextPath}/assetsLP/img/${type}.jpg" height="300px" width="350px" alt=""></a>
                                            </div>
                                            <div class="member-info">
                                                <h1>${type}</h1>
                                            </div>
                                        </c:if>
                                        <c:if test="${type == 'Return'}" >
                                            <div class="member-img">
                                                <a href="http://localhost:8080/TheFinalPOS/ShowCategories?action=Return&cashierId=${user.getId()}"><img src="${pageContext.request.contextPath}/assetsLP/img/${type}.jpg" height="300px" width="350px" alt=""></a>
                                            </div>
                                            <div class="member-info">
                                                <h1>${type}</h1>
                                            </div>
                                        </c:if>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </section>
            </main>
        </c:if>

        <div id="preloader"></div>
        <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

        <!-- Vendor JS Files -->
        <script src="${pageContext.request.contextPath}/assetsLP/vendor/purecounter/purecounter.js"></script>
        <script src="${pageContext.request.contextPath}/assetsLP/vendor/aos/aos.js"></script>
        <script src="${pageContext.request.contextPath}/assetsLP/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="${pageContext.request.contextPath}/assetsLP/vendor/glightbox/js/glightbox.min.js"></script>
        <script src="${pageContext.request.contextPath}/assetsLP/vendor/isotope-layout/isotope.pkgd.min.js"></script>
        <script src="${pageContext.request.contextPath}/assetsLP/vendor/swiper/swiper-bundle.min.js"></script>
        <script src="${pageContext.request.contextPath}/assetsLP/vendor/waypoints/noframework.waypoints.js"></script>
        <script src="${pageContext.request.contextPath}/assetsLP/vendor/php-email-form/validate.js"></script>

        <!-- Template Main JS File -->
        <script src="${pageContext.request.contextPath}/assetsLP/js/main.js"></script>
    </body>
</html>
