window.onload = function() {
	init();
	top.show.location.href = "/html/show.html";
}
function init() {
	var imgs = getT("img");
	for(var i = 0; i < imgs.length; i++) {
		imgs[i].src = "/img/top0.jpg";
	}
	setTimeout(turn, 3000);
}
var srcStatus = 1;
function turn() {
	var imgs = getT("img");
	for(var i = 0; i < imgs.length; i++) {
		var delay = Math.floor(Math.random() * 3);
		imgs[i].style.animationDelay = "0." + delay + "s";
		imgs[i].className = "top turn";
	}
	if(srcStatus % 2 == 1) {
		setTimeout(turn, 2000);
	} else {
		setTimeout(turn, 4000);
	}
	setTimeout(changeSrc, 500);
	setTimeout(classBack, 1000);
}
function changeSrc() {
	var src;
	if(srcStatus % 2 == 0) {
		src = "/img/top0.jpg";
	} else if(srcStatus % 4 == 1) {
		src = "/img/top1.jpg";
	} else {
		src = "/img/top2.jpg";
	}
	srcStatus++;
	var imgs = getT("img");
	for(var i = 0; i < imgs.length; i++) {
		imgs[i].src = src;
	}
}
function classBack() {
	var imgs = getT("img");
	for(var i = 0; i < imgs.length; i++) {
		imgs[i].className = "top";
	}
}