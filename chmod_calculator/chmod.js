document.addEventListener("DOMContentLoaded", async () => {
    const boxes = document.getElementsByClassName("form-check-input");
    for (let i = 0; i < boxes.length; i++) {
        boxes[i].addEventListener("click", boxToSym);
        boxes[i].addEventListener("click", boxToOct);
    };
});


document.addEventListener("DOMContentLoaded", async () => {
    symField = document.getElementById("sym");
    await symField.addEventListener("change", symToBox);
    symField.addEventListener("change", boxToOct);
});


document.addEventListener("DOMContentLoaded", async () => {
    octField = document.getElementById("oct");
    await octField.addEventListener("change", octToSym);
    octField.addEventListener("change", symToBox);
});

async function boxToSym() {
    const boxIDs = ["or","ow","ox","gr","gw","gx","wr","ww","wx"];
    let symString = "";
    for (const id of boxIDs) {
        const box = document.getElementById(id);
        if (box.checked) {
            symString += id[1];
        } else {
            symString += '-';
        }
    }
    symField = document.getElementById("sym");
    symField.value = symString;
}

async function boxToOct() {
    const boxPairs = new Map([
        ["or", 400], ["gr", 40], ["wr", 4],
        ["ow", 200], ["gw", 20], ["ww", 2],
        ["ox", 100], ["gx", 10], ["wx", 1] ]);

    let octValue = 0;
    for (const id of boxPairs.keys()) {
        const box = document.getElementById(id);
        if (box.checked) {
            octValue += boxPairs.get(id);
        }
    }

    const valAsString = octValue.toString();
    const digits = valAsString.length;
    switch (digits) {
        case 1:
            octValue = '00' + valAsString;
            break;
        case 2:
            octValue = '0' + valAsString;
            break;
    }
    
    octField = document.getElementById("oct");
    octField.value = octValue;
    
}

async function symToBox() {
    const boxIDs = ["or","ow","ox","gr","gw","gx","wr","ww","wx"];
    const symField = document.getElementById("sym");
    const symValue = symField.value;

    for (let i = 0; i < symValue.length; i++) {
        const box = document.getElementById(boxIDs[i]);
        if (symValue[i] === '-') {
            box.checked = false;
        } else if (symValue[i] === 'r') {
            box.checked = true;
        } else if (symValue[i] === 'w') {
            box.checked = true;
        } else if (symValue[i] === 'x') {
            box.checked = true;
        }
    }
}

async function octToSym() {
    octField = document.getElementById("oct");
    let substring = '';
    for (let i = 0; i < 3; i++) { 
        let x = parseInt(octField.value[i]);
        switch (x) {
            case 0:
                substring += '---';
                break;
            case 1:
                substring += '--x';
                break;
            case 2:
                substring += '-w-';
                break;
            case 3:
                substring += '-wx';
                break;
            case 4:
                substring += 'r--';
                break;
            case 5:
                substring += 'r-x';
                break;
            case 6:
                substring += 'rw-';
                break;
            case 7:
                substring += 'rwx';
                break;
        }
    }
    const symField = document.getElementById("sym");
    symField.value = substring;
}
