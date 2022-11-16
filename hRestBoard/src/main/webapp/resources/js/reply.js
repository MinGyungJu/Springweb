
$(function(){

// '댓글추가' 버튼이 눌렸을 때
 $('#replyConfirm').click(function(){
 
 	//사용자 입력값 받아오기
 	/*var param= { bno : $('#bno').val(),
 				 replyer : $('#replyer').val(),
 				 reply : $('#reply').val()
 				
 				 };*/
 	 var param = $('#replyFrm').serialize();
 	//alert(param);	
 	//console.log(param);
 	
 	$.ajax({
 		type : 'post',
 		url : '../replies/new',
 		data : param,
 		success : function(result){
 					//alert(result)
 					$("#reply").val("");
 					},
 		error : function(err){
 				alert('error')
 				console.log(err);
 				}
 		
 	})
 	
 	});// end of click
 	
 	replyList();
 	function replyList(){
 	
 		$.ajax({
 			type : "get",
 			url : "../replies",
 			// data : 보내는 데이타없음
 			dataType : 'json',	// 라이브러리필요
 			success : function(result){
 					//alert(result);
 					//console.log(result);
 					
 					let replyTbl = $('#replyList');
 					replyTbl.empty();
 					for( row of result){
 							//console.log(row);
 							var tr = $('<tr/>');
 							tr.append( $('<td/>').html(row['rno']) );
 							tr.append( $('<td/>').html(row['replyer']));
 							tr.append( $('<td/>').html(row['reply']) );
 							tr.append( $('<td/>').html(row['replydate']) );
 							
 							tr.append('<td><button class="delete">삭제</button></td>');
 							tr.append('<td><button class="modify">수정</button></td>');	
 							
 							replyTbl.append(tr);
 						}
 					},
 			error : function(err){
 					alert('error');
 					console.log(err);
 					}
 		})
 	}// end of replyList()
 	
 	//삭제버튼을 클릭했을때
 	
 	//$('#replyList .delete').on('click',function(){
 	//alert('ok');
 	//})
 	
 	$('#replyList').on('click','.delete',function(){
 			var btn = $(this);
 			
 			var rno = $(this).parents('tr').children().eq(0).text();
 			
 			$.ajax({
 				type : 'delete',
 				url : '../replies/' + rno,
 				success : function(result){
 					replyList();
 				},
 				error : function(err){
 						alert('에러');
 				}
 			});
 	});
 	
 	$('#replyList').on('click','.modify',function(){
 			var btn = $(this);
 			
 			$.ajax({
 				type : 'modify',
 				url : '/replies/9',
 				success : function(result){
 					replyList();
 				},
 				error : function(err){
 						alert('에러');
 				}
 			});
 	});
 	
 	

});