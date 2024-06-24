(function () {
    addOpenButtonListener();
}());

function addOpenButtonListener() {
    $('.contact-button').click(function(event) {
        event.preventDefault(); // Tambahkan ini untuk mencegah perilaku default link
        $('.modal-layer').addClass('modal-layer--opened');
        $('.dropdown-dialog').addClass('contact-dialog--opened');
    });

    // Tambahkan event listener untuk menutup modal jika pengguna mengklik di luar dialog
    $(window).click(function(event) {
        if ($(event.target).hasClass('modal-layer')) {
            $('.modal-layer').removeClass('modal-layer--opened');
            $('.dropdown-dialog').removeClass('contact-dialog--opened');
        }
    });
}
