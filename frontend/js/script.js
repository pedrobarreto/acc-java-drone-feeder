

const addBody = document.querySelector('.container-grid');

function createCustomElement(element, className, innerText) {
  const item = document.createElement(element);
  item.className = className;
  item.innerText = innerText;
  return item;
}

function createDronesCard({ nome, status, latitude, longitude, id }) {

  const section = document.createElement('section');
  section.className = 'drone-card';
  section.appendChild(createCustomElement('span', 'drone-model', `Modelo: ${nome}`));
  section.appendChild(createCustomElement('span', 'drone-status', `Status: ${status}`));
  section.appendChild(createCustomElement('button', 'drone-location', 'Ver Localização'));
  section.querySelector('.drone-location').addEventListener('click', () => verLocalizacao(latitude, longitude));
  section.appendChild(createCustomElement('button', 'drone-orders', 'Ver Pedidos'));
  section.querySelector('.drone-orders').addEventListener('click', () => verPedidos(id));

return section;
 
}

function createPedidosCard({ nome, status, drone, id, videoId, data }) {

  const date = new Date(data);
  const formatDate = ((date.getDate() )) + "/" + ((date.getMonth() + 1)) + "/" + date.getFullYear(); 
  const section = document.createElement('div');
  section.className = 'pedido-card';
  section.appendChild(createCustomElement('span', 'pedido-id', `Id do Pedido:  ${id}`));
  section.appendChild(createCustomElement('span', 'pedido-data', `Data: ${formatDate}`));
  section.appendChild(createCustomElement('span', 'pedido-status', `Status: ${status}`));
  section.appendChild(createCustomElement('span', 'pedido-drone', `Drone Responsável: ${drone.nome}`));
  if(videoId) {
  section.appendChild(createCustomElement('button', 'pedido-video', 'Ver Vídeo'));
  section.querySelector('.pedido-video').addEventListener('click', () => verVideo(videoId));
  }

return section;
 
}

const verPedidos = (droneId) => {
  fetchApi(`drones/${droneId}/entregas`);
}

const verLocalizacao = (latitude, longitude) => {
  const localizacao = basicLightbox.create(`
  <iframe src="//maps.google.com/maps?q=${latitude},${longitude}&z=15&output=embed"></iframe>
`
)
  localizacao.show();
}

const verVideo = (videoId) => {
  const video = basicLightbox.create(`
  <video controls>
      <source src="http://localhost:8080/videos/${videoId}" type="video/mp4">
  </video>
  <br/>
  <a class="download-video" href="http://localhost:8080/videos/${videoId}">Baixar Vídeo</a>
`)
  video.show();
}


const fetchApi = (endpoint) => {
  addBody.innerHTML = '<h2 class =\'loading\'>Carregando...</h2>';
  fetch(`http://localhost:8080/${endpoint}`)
   .then((response) => response.json()
   .then((dados) => {

    addBody.innerHTML = '';

    if(endpoint === 'drones') {
    dados.map((key) => addBody.appendChild(createDronesCard(key)));
    } 
    dados.map((key) => addBody.appendChild(createPedidosCard(key)));
    
   }));
   };


    

  window.onload = () => { 
    fetchApi("drones");
   };