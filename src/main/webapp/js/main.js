/**
 * Main JS File
 */

$(document).ready(
		function() {
			var top = $('#ctrls').offset().top
					- parseFloat($('#ctrls').css('marginTop').replace(/auto/,
							100));
			$(window).scroll(function(event) {
				var y = $(this).scrollTop();

				if (y >= top) {
					$('#ctrls').addClass('floater');
				} else {
					$('#ctrls').removeClass('floater');
				}
			});
		});