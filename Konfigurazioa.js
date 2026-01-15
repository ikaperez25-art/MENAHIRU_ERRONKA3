const products = [
    {
        productName: "Skoda Fabia",
        price: 18000,
        img: "img/skoda_fabia.png",
        category: 'gasolina'
    },
    {
        productName: "Skoda Kamiq",
        price: 24000,
        img: "img/skoda_kamiq.png",
        category: 'gasolina'
    },
    {
        productName: "Skoda Karoq",
        price: 30000,
        img: "img/skoda_karoq_diesel.png",
        category: 'diesel'
    },
    {
        productName: "Skoda Octavia",
        price: 28000,
        img: "img/skoda_octavia_diesel.png",
        category: 'diesel'
    },
    {
        productName: "Skoda Enyaq iV",
        price: 45000,
        img: "img/skoda_enyaq_iv.png",
        category: 'elektrikoa'
    },
    {
        productName: "Skoda Enyaq Coupé",
        price: 50000,
        img: "img/skoda_enyaq_coupe.png",
        category: 'elektrikoa'
    },
    {
        productName: "Skoda Octavia iV",
        price: 35000,
        img: "img/skoda_octavia_iv.png",
        category: 'hibridoa'
    },
    {
        productName: "Skoda Superb iV",
        price: 42000,
        img: "img/skoda_superb_iv.png",
        category: 'hibridoa'
    }
];

const displayProducts = (productsToShow) => {
    const shopContent = document.getElementById("shopContent");

    shopContent.innerHTML = "";
    productsToShow.forEach(product => {
        const div = document.createElement("div");
        div.className = 'card-products';

        div.style.border = "1px solid #ccc";
        div.style.padding = "1rem";
        div.style.borderRadius = "8px";
        div.style.width = "250px";
        div.style.textAlign = "center";
        div.style.backgroundColor = "#fff";
        div.style.color = "#000";

        div.innerHTML = `
        <img src="${product.img}" alt="${product.productName}" style="width: 100%; height: 180px; object-fit: contain; margin-bottom: 10px;">
        <h3>${product.productName}</h3>
        <p class="price">${product.price.toLocaleString()} €</p>
        <div style="display: flex; gap: 10px; margin-top: auto;">
            <button onclick="finantzatu('${product.productName}', ${product.price}, '${product.img}')" style="background-color: #2196F3; color: white; padding: 10px 15px; border: none; cursor: pointer; border-radius: 5px;">💳 Finantzatu</button>
            <button onclick="erosi('${product.productName}', ${product.price}, '${product.img}')" style="background-color: #4CAF50; color: white; padding: 10px 15px; border: none; cursor: pointer; border-radius: 5px;">🛒 Erosi</button>
        </div>
      `;
        div.style.display = "flex";
        div.style.flexDirection = "column";
        div.style.alignItems = "center";
        div.style.justifyContent = "space-between";
        div.style.height = "380px";
        shopContent.append(div);
    });
};

const finantzatu = (izena, prezioa, irudia) => {
    window.location.href = 'Finantziazioa.html';
};

const erosi = (izena, prezioa, irudia) => {
    window.location.href = 'Saskia.html';
};

const filterProducts = (category) => {
    const productsToShow = products.filter(product => product.category === category);
    displayProducts(productsToShow);
};

const gasolinaBtn = document.getElementById('gasolinaBtn');
const dieselBtn = document.getElementById('dieselBtn');
const elektrikoaBtn = document.getElementById('elektrikoaBtn');
const hibridoaBtn = document.getElementById('hibridoaBtn');
const denakBtn = document.getElementById('denakBtn');

gasolinaBtn.addEventListener('click', () => {
    filterProducts('gasolina');
});

dieselBtn.addEventListener('click', () => {
    filterProducts('diesel');
});

elektrikoaBtn.addEventListener('click', () => {
    filterProducts('elektrikoa');
});

hibridoaBtn.addEventListener('click', () => {
    filterProducts('hibridoa');
});

denakBtn.addEventListener('click', () => {
    displayProducts(products);
});

displayProducts(products);
