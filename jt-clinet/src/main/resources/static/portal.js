GET: $(document).ready(
		function() {

			// GET REQUEST
			$("#accessjavatechie").click(function(event) {
				event.preventDefault();
				ajaxGet();
			});

			// DO GET
			function ajaxGet() {
				$.ajax({
					url : "http://localhost:8080/access",
					success : function(result) {
						$("#result").html(result);
					}
				});
			}
		})
