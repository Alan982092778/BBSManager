<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />

  <!-- Favicon -->
  <link rel="icon" type="image/png" sizes="48x48" href="${pageContext.request.contextPath}/images/favicon.png">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Great+Vibes&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,400i,500,500i,600&display=swap" rel="stylesheet">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" />

  <!-- Fontawesome CSS-->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/all.css" />

  <!-- slick css -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/slick.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/slick-theme.css">

  <!-- Custom CSS -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/preloader.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/responsive.css" />

  <title>Kavya - Minimal Blog Template</title>

  <title>Kavya</title>
</head>

<body>
  <main class="kavya-single">
    <!-- single layout blog content -->
    <section class="single-layout">
      <div class="container">
        <div class="row align-items-center">
          <div class="col-md-10 offset-md-1 col-lg-8 offset-lg-2">
            <div class="blog-content-wrap">
              
            
              <div class="blog-author-info">
                <%-- <div class="author-img">
                  <img src="${pageContext.request.contextPath}/static/assets/images/writer.jpg" alt="">
                </div> --%>
                <div class="author-desc">
                 <!--  <small>written by</small>
                  <h5>Julie Perry</h5> -->
                  <p>${ins.invi.invitationMessage }</p>
                </div>
              </div>
              <div class="comment-section">
                <div class="all-response">
                  <a class="btn view-all-btn" data-toggle="collapse" href="#collapseExample" role="button"
                    aria-expanded="false" aria-controls="collapseExample">
                    	顯示所有的回復信息
                  </a>
                </div>
                <div class="collapse" id="collapseExample">
                	<c:forEach items="${ins.ans }" var="ans">
                		 <div class="card comment-card">
		                    <div class="card-body">
		                      <div class="author-date">
		                        <%-- <div class="author">
		                          <img src="${pageContext.request.contextPath}/static/assets/images/person2.jpg" alt="" class="rounded-circle" />
		                        </div> --%>
		                        <div class="inner-author-date">
		                          <div class="author">
		                            <span class="">${userId}</span>
		                          </div>
		                          <div class="date"><span>${ans.ansDate }</span></div>
		                        </div>
		                      </div>
		                      <div class="comment-text mt-2">
		                        <div>${ans.ansMessage}</div>
		                      </div>
		                    </div>
		                  </div>
                	</c:forEach>
                 </div>
                <form class="comment-form" action="${pageContext.request.contextPath}/InvitationServerlt?op=addans" method="post">
                  <h5>Leave a comment</h5>
                  <div class="row">
                    <div class="col-12 col-md-6 mb-4">
                      <input type="hidden" class="form-control" name="userId" value="${userId }"/>
                    </div>
                    <div class="col-12 col-md-6 mb-4">
                      <input type="hidden" class="form-control" name="inviId" value="${ins.invi.invitationId}">
                    </div>
                    <div class="col-12 mb-4">
                      <textarea rows="7" class="form-control" name="ansMessage" placeholder="請錄入回復的內容"></textarea>
                    </div>
                  </div>
                  <input class="btn btn-solid" type="submit" value="增加回復">
                </form>
              </div>

            </div>
          </div>
        </div>
      </div>
    </section>
  </main>

  <!-- Javascript -->
  <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/slick.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/jquery.sticky.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/ResizeSensor.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/theia-sticky-sidebar.min.js"></script>
  <script
    src="https://platform-api.sharethis.com/js/sharethis.js#property=5e14739168a9ad001281e73c&product=inline-share-buttons"
    async="async"></script>
  <script src="${pageContext.request.contextPath}/static/js/main.js"></script>


</body>

</html>