
function checkIdentificationNo(inputId) {
    var code = $("#" + inputId).val();
    if (code && code != "") {
        if (!validateNumber(code)) {
            //             "digit only";
            return 1;
        }

        if (code.length != 10) {
            //            "ten digit only";
            return 2;
        }


        if ((parseFloat(code) % 1111111111) == 0) {
            //            "repeated digits";
            return 3;
        }

        var X = tokenizeCodeToArray(code);
        var N = calculateN(X);
        var R = (N % 11);
        var resultC;
        switch (R) {
            case 0:
            case 1:
                resultC = R;
                break;
            default:
                resultC = 11 - R;
        }
        if (resultC != X[10 - 1]) {
            //            "not valid identification";
            return 4;
        }
    }
    return 0;
}

function tokenizeCodeToArray(code) {
    var result = new Array();
    for (var i = 0; i < code.length; i++) {
        result.push(parseFloat(code.charAt(i).toString()));
    }
    return result;
}

function calculateN(l) {
    var n = 0;
    for (var ii = 0; ii < 10 - 1; ii++) {
        n += l[ii] * (10 - ii);
    }
    return n;
}

function validateNumber(code) {
    if (code != "") {
        var tempcode = parseFloat(code);
        if (tempcode == undefined || ((code.charAt(0) == "0" && code.charAt(1) == 0 ? "00" : (code.charAt(0) == "0" ? "0" : "")) + tempcode.toString()) != code) {
            return false;
        }
        return true;
    } else {
        return false;
    }
}


