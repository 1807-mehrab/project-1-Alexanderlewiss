function loadRoom()
{	
	let xhr = new XMLHttpRequest(); 
	xhr.onreadystatechange = function(){
		if(this.readyState == 4)
			{
			   if(this.status == 200)
				   {
				        document.getElementById("par").innerHTML = xhr.responseText;
				   }else
					   {
					   console.log("Error: Cannot retrieve rooms ");
					   }
			}
		       document.getElementById("b").onclick = loadRoom(); 
		
		         xhr.open("GET", "/workspace-sts-3.9.5.RELEASE/Hotel/src/main/java/com/alex/hotel/ViewAServlet", true);
		         xhr.send();
	
	}
	 document.getElementById("b").onclick = loadRoom(); 
}