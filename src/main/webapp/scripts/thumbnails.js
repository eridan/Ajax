window.onload = initPage;

function initPage() {
	thumbs = document.getElementById("thumbnailPane").getElementsByTagName("img");
	
	for(var i=0; i<thumbs.length; i++) {
		image = thumbs[i];
		image.onclick = function() {
			detailUrl = 'images/'+ this.title +'-detail.jpg';
			document.getElementById("itemDetail").src = detailUrl;
			getDetails(this.title);
		}
	}
}

function createRequest() {
  try {
    request = new XMLHttpRequest();
  } catch (tryMS) {
    try {
      request = new ActiveXObject("Msxml2.XMLHTTP");
    } catch (otherMS) {
      try {
        request = new ActiveXObject("Microsoft.XMLHTTP");
      } catch (failed) {
        request = null;
      }
    }
  }
  return request;
}


function getDetails(itemName) {
	request = createRequest;
	if(request == null) {
		alert('Ooopsie! Sorry, I am unable to create a Request Object :(');
		return;
	}
	
	var url = "getDetails.php?ImageId=" + escape(itemName);
	request.open("GET",url,true);
	request.onreadystatechange = displayDetails;
	request.send(null);

}