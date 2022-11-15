<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Responsive Bootstrap4 Shop Template, Created by Imran Hossain from https://imransdesign.com/">

	<!-- title -->
	<title>Edit Beans</title>
	<%String pjName="/sj/";%>

	<!-- favicon -->
	<link rel="shortcut icon" type="image/png" href="<%=pjName%>resources/assets/img/favicon.png">
	<!-- google font -->
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet">
	<!-- fontawesome -->
	<link rel="stylesheet" href="<%=pjName%>resources/assets/css/all.min.css">
	<!-- bootstrap -->
	<link rel="stylesheet" href="<%=pjName%>resources/assets/bootstrap/css/bootstrap.min.css">
	<!-- owl carousel -->
	<link rel="stylesheet" href="<%=pjName%>resources/assets/css/owl.carousel.css">
	<!-- magnific popup -->
	<link rel="stylesheet" href="<%=pjName%>resources/assets/css/magnific-popup.css">
	<!-- animate css -->
	<link rel="stylesheet" href="<%=pjName%>resources/assets/css/animate.css">
	<!-- mean menu css -->
	<link rel="stylesheet" href="<%=pjName%>resources/assets/css/meanmenu.min.css">
	<!-- main style -->
	<link rel="stylesheet" href="<%=pjName%>resources/assets/css/main.css">
	<!-- responsive -->
	<link rel="stylesheet" href="<%=pjName%>resources/assets/css/responsive.css">

</head>
<body>
	
	<!--PreLoader-->
    <div class="loader">
        <div class="loader-inner">
            <div class="circle"></div>
        </div>
    </div>
    <!--PreLoader Ends-->
	
	<!-- header -->
	<div class="top-header-area" id="sticker">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-sm-12 text-center">
					<div class="main-menu-wrap">
						<!-- logo -->
						<div class="site-logo">
							<a href="index.jsp">
								<img src="resources/assets/img/logo.png" alt="">
							</a>
						</div>
						<!-- logo -->

						<!-- menu start -->
						<nav class="main-menu">
							<ul>
								<li><a href="index_m.jsp">ORDERS</a></li>
								<li class="current-list-item"><a href="#">COFFEE BEANS</a></li>
								<li><a href="shop2_m.jsp">GOODS</a></li>
								<li><a href="contact_m.jsp">SUPPORT</a>
								<li>
									<div class="header-icons">
										<a class="mobile-hide search-bar-icon" href="#"><i class="fas fa-search"></i></a>
									</div>
								</li>
							</ul>
						</nav>
						<a class="mobile-show search-bar-icon" href="#"><i class="fas fa-search"></i></a>
						<div class="mobile-menu"></div>
						<!-- menu end -->
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end header -->

	<!-- search area -->
	<div class="search-area">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<span class="close-btn"><i class="fas fa-window-close"></i></span>
					<div class="search-bar">
						<div class="search-bar-tablecell">
							<h3>Search For:</h3>
							<input type="text" placeholder="Keywords">
							<button type="submit">Search <i class="fas fa-search"></i></button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end search arewa -->
	
	<!-- breadcrumb-section -->
	<div class="breadcrumb-section breadcrumb-bg">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 offset-lg-2 text-center">
					<div class="breadcrumb-text">
						<p>Fresh and Organic</p>
						<h1>Edit Beans</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end breadcrumb section -->

	<!-- products -->
	<div class="product-section mt-150 mb-150">
		<div class="container">

			<div class="row">
                <div class="col-md-12">
                    <div class="product-filters">
                        <ul>
                            <li class="active" data-filter="*">All</li>
                            <li data-filter=".strawberry">Strawberry</li>
                            <li data-filter=".berry">Berry</li>
                        </ul>
                    </div>
                </div>
            </div>

			<div class="row product-lists">
				<div class="col-lg-4 col-md-6 text-center strawberry">
					<div class="single-product-item">
						<a href="single-product_m.jsp">
							<div class="product-image"><img src="resources/assets/img/products/plus.jpg" alt=""></div>
							<h3>Add Product</h3>
							<p class="product-price"><span>Per Kg</span> - </p> 
						</a>
					</div>
				</div> 
				<div class="col-lg-4 col-md-6 text-center strawberry">
					<div class="single-product-item">
						<a href="single-product_m.jsp">
							<div class="product-image">
								<img src="resources/assets/img/products/product-img-1.jpg" alt=""></a>
							</div>
							<h3>Strawberry</h3>
							<p class="product-price"><span>Per Kg</span> 85$ </p> 
						</a>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 text-center berry">
					<div class="single-product-item">
						<a href="single-product_m.jsp">
							<div class="product-image">
								<img src="resources/assets/img/products/product-img-2.jpg" alt=""></a>
							</div>
							<h3>Berry</h3>
							<p class="product-price"><span>Per Kg</span> 70$ </p> 
						</a>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 text-center berry">
					<div class="single-product-item">
						<a href="single-product_m.jsp">
							<div class="product-image">
								<img src="resources/assets/img/products/product-img-2.jpg" alt=""></a>
							</div>
							<h3>Berry</h3>
							<p class="product-price"><span>Per Kg</span> 70$ </p> 
						</a>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 text-center berry">
					<div class="single-product-item">
						<a href="single-product_m.jsp">
							<div class="product-image">
								<img src="resources/assets/img/products/product-img-2.jpg" alt=""></a>
							</div>
							<h3>Berry</h3>
							<p class="product-price"><span>Per Kg</span> 70$ </p> 
						</a>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 text-center berry">
					<div class="single-product-item">
						<a href="single-product_m.jsp">
							<div class="product-image">
								<img src="resources/assets/img/products/product-img-2.jpg" alt=""></a>
							</div>
							<h3>Berry</h3>
							<p class="product-price"><span>Per Kg</span> 70$ </p> 
						</a>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="pagination-wrap">
						<ul>
							<li><a href="#">Prev</a></li>
							<li><a href="#">1</a></li>
							<li><a class="active" href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">Next</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end products -->

	<!-- logo carousel -->
	<div class="logo-carousel-section">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="logo-carousel-inner">
						<div class="single-logo-item">
							<img src="resources/assets/img/company-logos/1.png" alt="">
						</div>
						<div class="single-logo-item">
							<img src="resources/assets/img/company-logos/2.png" alt="">
						</div>
						<div class="single-logo-item">
							<img src="resources/assets/img/company-logos/3.png" alt="">
						</div>
						<div class="single-logo-item">
							<img src="resources/assets/img/company-logos/4.png" alt="">
						</div>
						<div class="single-logo-item">
							<img src="resources/assets/img/company-logos/5.png" alt="">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end logo carousel -->

	<!-- footer -->
	<div class="footer-area">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-6">
					<div class="footer-box about-widget">
						<h2 class="widget-title">About us</h2>
						<p>We are proudly serving coffee beans and coffee related products to our customer. 
							Our duty is to please the customer with the best tasting bean and perfectly match the preferences of coffee.</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-6">
					<div class="footer-box get-in-touch">
						<h2 class="widget-title">Get in Touch</h2>
						<ul>
							<li>Seoul, Geumcheon-gu, Gasan digital 2-ro, 123 building2) 4th-floor (suite.413) World Meridian</li>
							<li>support@kosmo.com</li>
							<li> +02 2025 8523 </li>
						</ul>
					</div>
				</div>
				<div class="col-lg-3 col-md-6">
					<div class="footer-box pages">
						<h2 class="widget-title">Pages</h2>
						<ul>
							<li><a href="index_m.jsp">ORDERS</a></li>
							<li><a href="shop_m.jsp">COFFEE BEANS</a></li>
							<li><a href="shop2_m.jsp">GOODS</a></li>
							<li><a href="contact_m.jsp">SUPPORT</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end footer -->
	
	<!-- copyright -->
	<div class="copyright">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-12">
					<p>Copyrights &copy; 2019 - gitae joe,  All Rights Reserved.</p>
				</div>
				<div class="col-lg-6 text-right col-md-12">
					<div class="social-icons">
						<ul>
							<li><a href="#" target="_blank"><i class="fab fa-facebook-f"></i></a></li>
							<li><a href="#" target="_blank"><i class="fab fa-twitter"></i></a></li>
							<li><a href="#" target="_blank"><i class="fab fa-instagram"></i></a></li>
							<li><a href="#" target="_blank"><i class="fab fa-linkedin"></i></a></li>
							<li><a href="#" target="_blank"><i class="fab fa-dribbble"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end copyright -->
	
	<!-- jquery -->
	<script src="resources/assets/js/jquery-1.11.3.min.js"></script>
	<!-- bootstrap -->
	<script src="resources/assets/bootstrap/js/bootstrap.min.js"></script>
	<!-- count down -->
	<script src="resources/assets/js/jquery.countdown.js"></script>
	<!-- isotope -->
	<script src="resources/assets/js/jquery.isotope-3.0.6.min.js"></script>
	<!-- waypoints -->
	<script src="resources/assets/js/waypoints.js"></script>
	<!-- owl carousel -->
	<script src="resources/assets/js/owl.carousel.min.js"></script>
	<!-- magnific popup -->
	<script src="resources/assets/js/jquery.magnific-popup.min.js"></script>
	<!-- mean menu -->
	<script src="resources/assets/js/jquery.meanmenu.min.js"></script>
	<!-- sticker js -->
	<script src="resources/assets/js/sticker.js"></script>
	<!-- main js -->
	<script src="resources/assets/js/main.js"></script>

</body>
</html>