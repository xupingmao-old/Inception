$(document).ready(function()
{
    $('#navigation ul li a').hover(function()
    {
    	$(this).children().css({'display':'block'});
    });
})

$(document).ready(function()
{
	$(".level1").mouseenter( function(){
		$('.level1 ul').css({'display':'none'});
		// alert('ok');
		$(this).children("ul").css({'display': 'block', 'position': 'absolute', 'top':'40px', 'min-width':'200px',left:0})
		.mouseleave(function(){
			$(this).css({'display':'none'});

		})
	})

})