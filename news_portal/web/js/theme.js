var theme = getCookie('theme');
if (theme === 'dark') {
    document.body.classList.add('dark-theme');
    document.getElementById("dark_icon").setAttribute('src', '/static/day_icon.png');
} else {
    document.getElementById("dark_icon").setAttribute('src', '/static/night_icon.png');
}

function setCookie(name, value, days) {
    var expires = '';
    if (days) {
        var date = new Date();
        date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
        expires = '; expires=' + date.toUTCString();
    }
    document.cookie = name + '=' + (value || '')  + expires + '; path=/';
}

function getCookie(name) {
    var nameEQ = name + '=';
    var ca = document.cookie.split(';');
    for(var i=0;i < ca.length;i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1,c.length);
        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
    }
    return null;
}

var dark = document.getElementById('theme');

dark.onclick = function (){
    document.body.classList.toggle('dark-theme');
    icon = document.getElementById("dark_icon");
    if (icon.getAttribute('src') === '/static/night_icon.png') {
        icon.setAttribute('src', '/static/day_icon.png');
        setCookie('theme', 'dark', 365);
    } else {
        icon.setAttribute('src', '/static/night_icon.png');
        setCookie('theme', '', 365);
    }
}
