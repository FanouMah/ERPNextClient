// Popup logic for filter
const filterBtn = document.getElementById('open-filter-popup');
const filterPopup = document.getElementById('filter-popup');
const filterBtnGroup = document.getElementById('filter-btn-group');
let filterPopupOpen = false;

function openFilterPopup() {
  if (!filterPopupOpen) {
    // Position popup below the button group
    const rect = filterBtnGroup.getBoundingClientRect();
    filterPopup.style.display = 'block';
    filterPopupOpen = true;
  }
}

function closeFilterPopup() {
  filterPopup.style.display = 'none';
  filterPopupOpen = false;
}

filterBtn.addEventListener('click', function(e) {
  e.stopPropagation();
  if (filterPopupOpen) {
    closeFilterPopup();
  } else {
    openFilterPopup();
  }
});
// Close popup when clicking outside
document.addEventListener('mousedown', function(e) {
  if (filterPopupOpen && !filterPopup.contains(e.target) && !filterBtnGroup.contains(e.target)) {
    closeFilterPopup();
  }
});

// Update filter count badge
function updateActiveFilterCount() {
  let count = 0;
  document.querySelectorAll('#filter-rows .filter-row').forEach(function(row) {
    const value = row.querySelector('.filter-value');
    if (value && value.value.trim() !== '') count++;
  });
  document.getElementById('active-filter-count').textContent = count;
}
// Initial count
document.addEventListener('DOMContentLoaded', updateActiveFilterCount);

// Helper: get age from date string (yyyy-MM-dd)
function getAge(dateString) {
    if (!dateString) return '';
    const today = new Date();
    const dob = new Date(dateString);
    let age = today.getFullYear() - dob.getFullYear();
    const m = today.getMonth() - dob.getMonth();
    if (m < 0 || (m === 0 && today.getDate() < dob.getDate())) {
        age--;
    }
    return age;
}

// Update condition options based on field type
function updateConditionOptions(select) {
    const field = select.value;
    const row = select.closest('.filter-row');
    const conditionSelect = row.querySelector('.filter-condition');
    const ignoreCaseDiv = row.querySelector('.filter-ignore-case-div');
    const valueGroup = row.querySelector('.filter-value-group');
    conditionSelect.innerHTML = '';
    ignoreCaseDiv.style.display = 'none';
    valueGroup.innerHTML = '';

    if (['name', 'employeeName', 'gender', 'status', 'company'].includes(field)) {
        // Text fields
        conditionSelect.innerHTML = `
        <option value="equals">Equals to</option>
        <option value="like">Like</option>
        `;
        ignoreCaseDiv.style.display = '';
        valueGroup.innerHTML = `<input type="text" class="form-control filter-value" placeholder="Enter value">`;
    } else if (field === 'age') {
        // Number field
        conditionSelect.innerHTML = `
        <option value="equals">Equals to</option>
        <option value="gt">Bigger than</option>
        <option value="lt">Less than</option>
        <option value="between">Between</option>
        `;
        ignoreCaseDiv.style.display = 'none';
        valueGroup.innerHTML = `<input type="number" class="form-control filter-value" placeholder="Enter number">`;
    } else if (field === 'dateOfJoining') {
        // Date field
        conditionSelect.innerHTML = `
        <option value="equals">Equals to</option>
        <option value="after">After</option>
        <option value="before">Before</option>
        <option value="between">Between</option>
        `;
        ignoreCaseDiv.style.display = 'none';
        valueGroup.innerHTML = `<input type="date" class="form-control filter-value" placeholder="">`;
    }
    updateValueInputs(conditionSelect);
}

// Update value input(s) based on condition
function updateValueInputs(conditionSelect) {
    const row = conditionSelect.closest('.filter-row');
    const field = row.querySelector('.filter-field').value;
    const condition = conditionSelect.value;
    const valueGroup = row.querySelector('.filter-value-group');
    valueGroup.innerHTML = '';

    // Text fields
    if (['name', 'employeeName', 'gender', 'status', 'company'].includes(field)) {
        valueGroup.innerHTML = `<input type="text" class="form-control filter-value" placeholder="Enter value">`;
    }
    // Number field (age)
    else if (field === 'age') {
        if (condition === 'between') {
        valueGroup.innerHTML = `
            <input type="number" class="form-control filter-value filter-value-min" placeholder="Min">
            <span class="mx-1">-</span>
            <input type="number" class="form-control filter-value filter-value-max" placeholder="Max">
        `;
        } else {
        valueGroup.innerHTML = `<input type="number" class="form-control filter-value" placeholder="Enter number">`;
        }
    }
    // Date field (dateOfJoining)
    else if (field === 'dateOfJoining') {
        if (condition === 'between') {
        valueGroup.innerHTML = `
            <input type="date" class="form-control filter-value filter-value-min" placeholder="">
            <span class="mx-1">-</span>
            <input type="date" class="form-control filter-value filter-value-max" placeholder="">
        `;
        } else {
        valueGroup.innerHTML = `<input type="date" class="form-control filter-value" placeholder="">`;
        }
    }
}

// Add a new filter row
function addFilterRow() {
    const filterRows = document.getElementById('filter-rows');
    const firstRow = filterRows.querySelector('.filter-row');
    const newRow = firstRow.cloneNode(true);

    // Reset values
    newRow.querySelector('.filter-field').selectedIndex = 0;
    updateConditionOptions(newRow.querySelector('.filter-field'));
    newRow.querySelector('.btn-outline-danger').style.display = '';
    // Remove all value inputs and re-add default
    updateConditionOptions(newRow.querySelector('.filter-field'));

    filterRows.appendChild(newRow);
    }

    // Remove a filter row
    function removeFilterRow(btn) {
    const row = btn.closest('.filter-row');
    const filterRows = document.getElementById('filter-rows');
    if (filterRows.children.length > 1) {
        row.remove();
    }
}

// Reset all filters and show all rows
function resetFilters() {
    const filterRows = document.getElementById('filter-rows');
    // Remove all but the first row
    while (filterRows.children.length > 1) {
        filterRows.lastElementChild.remove();
    }
    // Reset first row
    const firstRow = filterRows.firstElementChild;
    firstRow.querySelector('.filter-field').selectedIndex = 0;
    updateConditionOptions(firstRow.querySelector('.filter-field'));
    firstRow.querySelector('.filter-condition').selectedIndex = 0;
    if (firstRow.querySelector('.filter-ignore-case')) {
        firstRow.querySelector('.filter-ignore-case').checked = true;
    }
    // Hide delete button for first row
    firstRow.querySelector('.btn-outline-danger').style.display = 'none';

    // Show all employee rows (re-add if needed)
    const tbody = document.querySelector('#employee-table tbody');
    const notFoundRow = document.getElementById('not-found-row');
    if (window._allEmployeeRows) {
        // Remove all current rows except not-found-row
        Array.from(tbody.querySelectorAll('tr.employee-row')).forEach(row => row.remove());
        // Re-add all original rows
        window._allEmployeeRows.forEach(row => tbody.appendChild(row));
    }
    if (notFoundRow) notFoundRow.style.display = 'none';
    updateActiveFilterCount();
    closeFilterPopup()
}

// Apply filters to the table
function applyFilters() {
    const tbody = document.querySelector('#employee-table tbody');
    const notFoundRow = document.getElementById('not-found-row');
    let rows = Array.from(document.querySelectorAll('#employee-table tbody tr.employee-row'));
    const filterRows = document.querySelectorAll('#filter-rows .filter-row');
    let anyVisible = false;

    // On first filter, store all rows for reset
    if (!window._allEmployeeRows) {
        window._allEmployeeRows = rows.map(row => row.cloneNode(true));
    }

    // Remove all current employee rows
    rows.forEach(row => row.remove());

    // Filter and re-add only matching rows
    let filteredRows = [];
    window._allEmployeeRows.forEach(origRow => {
        // Use a clone to avoid DOM detachment issues
        let row = origRow.cloneNode(true);
        let show = true;
        for (let filterRow of filterRows) {
            const field = filterRow.querySelector('.filter-field').value;
            const condition = filterRow.querySelector('.filter-condition').value;
            const ignoreCase = filterRow.querySelector('.filter-ignore-case') ? filterRow.querySelector('.filter-ignore-case').checked : false;
            let value = '';
            let valueMin = '';
            let valueMax = '';

            // Get value(s) depending on condition
            if (condition === 'between') {
                if (field === 'age' || field === 'dateOfJoining') {
                    valueMin = filterRow.querySelector('.filter-value-min') ? filterRow.querySelector('.filter-value-min').value : '';
                    valueMax = filterRow.querySelector('.filter-value-max') ? filterRow.querySelector('.filter-value-max').value : '';
                }
            } else {
                value = filterRow.querySelector('.filter-value') ? filterRow.querySelector('.filter-value').value : '';
            }

            let rowValue = '';
            if (field === 'age') {
                rowValue = getAge(row.getAttribute('data-dateofbirth'));
            } else if (field === 'dateOfJoining') {
                rowValue = row.getAttribute('data-dateofjoining');
            } else {
                rowValue = row.getAttribute('data-' + field.toLowerCase());
            }

            // Text fields
            if (['name', 'employeeName', 'gender', 'status', 'company'].includes(field)) {
                let compareValue = value || '';
                let compareRowValue = rowValue || '';
                if (ignoreCase) {
                    compareValue = compareValue.toLocaleLowerCase();
                    compareRowValue = compareRowValue.toLocaleLowerCase();
                }
                if (condition === 'equals') {
                    if (compareRowValue !== compareValue) show = false;
                } else if (condition === 'like') {
                    if (!compareRowValue.includes(compareValue)) show = false;
                }
            }
            // Number field (age)
            else if (field === 'age') {
                const age = parseInt(rowValue, 10);
                if (condition === 'equals') {
                    if (age != value) show = false;
                } else if (condition === 'gt') {
                    if (age <= value) show = false;
                } else if (condition === 'lt') {
                    if (age >= value) show = false;
                } else if (condition === 'between') {
                    if (valueMin === '' || valueMax === '' || isNaN(valueMin) || isNaN(valueMax)) {
                        show = false;
                    } else {
                        const min = parseInt(valueMin, 10);
                        const max = parseInt(valueMax, 10);
                        if (age < min || age > max) show = false;
                    }
                }
            }
            // Date field (dateOfJoining)
            else if (field === 'dateOfJoining') {
                const rowDate = rowValue ? new Date(rowValue) : null;
                if (!rowDate || isNaN(rowDate.getTime())) {
                    show = false;
                    continue;
                }
                if (condition === 'equals') {
                    const filterDate = value ? new Date(value) : null;
                    if (!filterDate || rowDate.toISOString().slice(0,10) !== filterDate.toISOString().slice(0,10)) show = false;
                } else if (condition === 'after') {
                    const filterDate = value ? new Date(value) : null;
                    if (!filterDate || rowDate <= filterDate) show = false;
                } else if (condition === 'before') {
                    const filterDate = value ? new Date(value) : null;
                    if (!filterDate || rowDate >= filterDate) show = false;
                } else if (condition === 'between') {
                    if (valueMin === '' || valueMax === '') {
                        show = false;
                    } else {
                        const min = new Date(valueMin);
                        const max = new Date(valueMax);
                        if (isNaN(min.getTime()) || isNaN(max.getTime()) || rowDate < min || rowDate > max) show = false;
                    }
                }
            }
        }
        if (show) {
            tbody.appendChild(row);
            anyVisible = true;
        }
    });

    // Show/hide not found row
    if (notFoundRow) notFoundRow.style.display = anyVisible ? 'none' : '';
    updateActiveFilterCount();
    }

    // On page load, set up first row
    document.addEventListener('DOMContentLoaded', function() {
    // Hide delete button for first row
    document.querySelectorAll('.filter-row .btn-outline-danger').forEach((btn, idx) => {
        if (idx === 0) btn.style.display = 'none';
    });
    // Set up initial condition options
    document.querySelectorAll('.filter-field').forEach(updateConditionOptions);
    // Set up onchange for all filter-condition selects
    document.querySelectorAll('.filter-condition').forEach(function(sel) {
        sel.addEventListener('change', function() { updateValueInputs(sel); });
    });
});

// When a new row is added, set up its events
document.getElementById('filter-rows').addEventListener('DOMNodeInserted', function(e) {
    if (e.target.classList && e.target.classList.contains('filter-row')) {
        const selField = e.target.querySelector('.filter-field');
        const selCond = e.target.querySelector('.filter-condition');
        selField.addEventListener('change', function() { updateConditionOptions(selField); });
        selCond.addEventListener('change', function() { updateValueInputs(selCond); });
    }
});