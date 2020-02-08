$("#qlogo,#mineinfo").hover(function(){
	$('#mineinfo').attr('class','collapse in list-group')
},function(){
	$("#mineinfo").attr('class','collapse list-group')
})
$("#exit").on('click',function () { 
	$('#exit').popover('show');
})
$(".popover-options").popover({
	html : true 
});
function no(){
	$('#exit').click()
}
$('.a').on('click',function(){
	var span=$(this).find("span").eq(1)
	var spanClass=span.attr('class')
	
	if(spanClass=='glyphicon glyphicon-chevron-down small'){
		span.attr('class','glyphicon glyphicon-chevron-up small')	
	}else{
		span.attr('class','glyphicon glyphicon-chevron-down small')
	}
})
