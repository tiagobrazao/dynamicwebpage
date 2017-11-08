<%@ attribute name="id" required="true" %>
	
	<input class="datepicker" 
		   name="entry_date" 
		   style="color:#000000" />

			
	<script> 
		$('.datepicker').datepicker({showAnim: "fadeIn", dateFormat: 'dd/mm/yy'}); 
	</script>
	