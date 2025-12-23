let totalAmount = 0;

function addExpense() {
    const category = document.getElementById("category").value;
    const amount = document.getElementById("amount").value;
    const note = document.getElementById("note").value;
    const mode = document.getElementById("mode").value;

    if (!category || !amount || !note || !mode) {
        alert("Please fill all fields");
        return;
    }

    const table = document.getElementById("expenseTable");

    const row = document.createElement("tr");
    row.innerHTML = `
        <td>${category}</td>
        <td>₹${parseFloat(amount).toFixed(2)}</td>
        <td>${note}</td>
        <td>${mode}</td>
    `;
    table.appendChild(row);

    // ✅ Keep decimals
    totalAmount += parseFloat(amount);

    // ✅ Points = total amount (with 2 decimals)
    const totalPoints = totalAmount.toFixed(2);

    document.getElementById("total").innerText = totalAmount.toFixed(2);
    document.getElementById("points").innerText = totalPoints;

    // Clear inputs
    document.getElementById("category").value = "";
    document.getElementById("amount").value = "";
    document.getElementById("note").value = "";
    document.getElementById("mode").value = "";
}
