
document.addEventListener('DOMContentLoaded', function () {
    
    flatpickr('#openTime', {
        enableTime: true,
        noCalendar: true,
        dateFormat: "H:i",
        time_24hr: true,
        locale: 'ja'
    });
    
    flatpickr('#closeTime', {
        enableTime: true,
        noCalendar: true,
        dateFormat: "H:i",
        time_24hr: true,
        locale: 'ja'
    });
	
	let maxDate = new Date();
 	maxDate = maxDate.setMonth(maxDate.getMonth() + 3);
    
    flatpickr('#holiday', {
		minDate: "today",
		maxDate: maxDate,
		mode: "multiple",
		dateFormat: "Y-m-d",
		locale: 'ja'
	});
});