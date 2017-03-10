/**
 * Get Ajax
 * @param url
 * @param options
 * @param callback
 */
function ajaxGet(url, options, callback) {
    $.ajax({
        url: url,
        data: options,
        async: true,
        dataType: 'json',
        type: 'GET',
        timeout: 5000,
        success: callback
    });
}

/**
 * Post Ajax
 * @param url
 * @param options
 * @param callback
 */
function ajaxPost(url, options, callback) {
    $.ajax({
        url: url,
        data: options,
        async: true,
        dataType: 'json',
        type: 'POST',
        timeout: 500000,
        success: callback
    });
}