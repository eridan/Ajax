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