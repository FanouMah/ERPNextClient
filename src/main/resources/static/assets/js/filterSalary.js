// Popup logic for filter (adapté pour filtrer par mois sur salary-slips.html)
const filterBtn = document.getElementById('open-filter-popup');
const filterPopup = document.getElementById('filter-popup');
const filterBtnGroup = document.getElementById('filter-btn-group');
let filterPopupOpen = false;

function openFilterPopup() {
  if (!filterPopupOpen) {
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

document.addEventListener('mousedown', function(e) {
  if (filterPopupOpen && !filterPopup.contains(e.target) && !filterBtnGroup.contains(e.target)) {
    closeFilterPopup();
  }
});

// Met à jour le badge du nombre de filtres actifs (mois seulement ici)
function updateActiveFilterCount() {
  let count = 0;
  const monthValue = document.querySelector('#filter-month').value;
  if (monthValue && monthValue.trim() !== '') count = 1;
  document.getElementById('active-filter-count').textContent = count;
}
document.addEventListener('DOMContentLoaded', updateActiveFilterCount);

// Réinitialise le filtre (affiche tous les bulletins)
function resetFilters() {
  const monthSelect = document.getElementById('filter-month');
  if (monthSelect) monthSelect.selectedIndex = 0;

  // Réaffiche toutes les lignes du tableau
  const tbody = document.querySelector('#salary-table tbody');
  const notFoundRow = document.getElementById('not-found-row');
  if (window._allSalaryRows) {
    Array.from(tbody.querySelectorAll('tr.salary-row')).forEach(row => row.remove());
    window._allSalaryRows.forEach(row => tbody.appendChild(row));
  }
  if (notFoundRow) notFoundRow.style.display = 'none';
  document.querySelector('#filter-month').value = '';
  updateActiveFilterCount();
  closeFilterPopup();
}

// Applique le filtre par mois sur le tableau des bulletins de salaire
function applyFilters() {
  const tbody = document.querySelector('#salary-table tbody');
  const notFoundRow = document.getElementById('not-found-row');
  const monthValue = document.getElementById('filter-month').value;
  let rows = Array.from(document.querySelectorAll('#salary-table tbody tr.salary-row'));
  let anyVisible = false;

  // Stocke toutes les lignes originales au premier filtrage
  if (!window._allSalaryRows) {
    window._allSalaryRows = rows.map(row => row.cloneNode(true));
  }

  // Supprime toutes les lignes actuelles
  rows.forEach(row => row.remove());

  // Filtre et réajoute les lignes correspondantes
  window._allSalaryRows.forEach(origRow => {
    let row = origRow.cloneNode(true);
    let show = true;

    if (monthValue && monthValue.trim() !== '') {
      // On suppose que chaque ligne a un attribut data-month="yyyy-MM"
      const rowMonth = row.getAttribute('data-month');
      if (rowMonth !== monthValue) show = false;
    }

    if (show) {
      tbody.appendChild(row);
      anyVisible = true;
    }
  });

  // Affiche ou masque la ligne "not found"
  if (notFoundRow) notFoundRow.style.display = anyVisible ? 'none' : '';
  updateActiveFilterCount();
}

// Initialisation à l'ouverture de la page
document.addEventListener('DOMContentLoaded', function() {
  // Stocke toutes les lignes originales pour reset
  const tbody = document.querySelector('#salary-table tbody');
  if (tbody && !window._allSalaryRows) {
    window._allSalaryRows = Array.from(tbody.querySelectorAll('tr.salary-row')).map(row => row.cloneNode(true));
  }
  // Cache le bouton supprimer si besoin (pas de multi-filtres ici)
  // Ajoute l'event sur le bouton "Appliquer"
  const applyBtn = document.getElementById('apply-filter-btn');
  if (applyBtn) {
    applyBtn.addEventListener('click', function(e) {
      e.preventDefault();
      applyFilters();
      closeFilterPopup();
    });
  }
  // Met à jour le badge au chargement
});