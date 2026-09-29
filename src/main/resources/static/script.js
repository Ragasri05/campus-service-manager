const API_URL = "/api/requests";

const requestForm = document.getElementById("requestForm");
const requestsContainer = document.getElementById("requestsContainer");


requestForm.addEventListener("submit", async function (event) {

    event.preventDefault();

    const request = {
        title: document.getElementById("title").value,
        description: document.getElementById("description").value,
        category: document.getElementById("category").value,
        priority: document.getElementById("priority").value
    };

    try {

        const response = await fetch(API_URL, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(request)
        });

        if (!response.ok) {
            throw new Error("Failed to create request");
        }

        alert("Service request created successfully!");

        requestForm.reset();

        loadRequests();

    } catch (error) {

        console.error(error);
        alert("Could not create service request.");

    }

});


async function loadRequests() {

    try {

        const response = await fetch(API_URL);

        const requests = await response.json();

        requestsContainer.innerHTML = "";

        if (requests.length === 0) {

            requestsContainer.innerHTML =
                "<p>No service requests found.</p>";

            return;
        }

        requests.forEach(request => {

            const card = document.createElement("div");

            card.className = "request-card";

            card.innerHTML = `
                <h3>${request.title}</h3>

                <p>${request.description}</p>

                <div class="meta">

                    <span class="badge">
                        ${request.category}
                    </span>

                    <span class="badge ${request.priority.toLowerCase()}">
                        ${request.priority}
                    </span>

                    <span class="badge status">
                        ${request.status}
                    </span>

                </div>

                <p>
                    Created:
                    ${new Date(request.createdAt).toLocaleString()}
                </p>

                ${
                    request.status !== "RESOLVED"
                    ?
                    `<button
                        class="resolve-btn"
                        onclick="resolveRequest(${request.id})">
                        Mark Resolved
                    </button>`
                    :
                    ""
                }

                <button
                    class="delete-btn"
                    onclick="deleteRequest(${request.id})">
                    Delete
                </button>
            `;

            requestsContainer.appendChild(card);

        });

    } catch (error) {

        console.error(error);

        requestsContainer.innerHTML =
            "<p>Failed to load requests.</p>";

    }

}


async function resolveRequest(id) {

    try {

        const response = await fetch(`${API_URL}/${id}`);

        const request = await response.json();

        request.status = "RESOLVED";

        await fetch(`${API_URL}/${id}`, {

            method: "PUT",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify(request)

        });

        loadRequests();

    } catch (error) {

        console.error(error);

        alert("Could not update request.");

    }

}


async function deleteRequest(id) {

    if (!confirm("Delete this service request?")) {
        return;
    }

    try {

        await fetch(`${API_URL}/${id}`, {
            method: "DELETE"
        });

        loadRequests();

    } catch (error) {

        console.error(error);

        alert("Could not delete request.");

    }

}


loadRequests();