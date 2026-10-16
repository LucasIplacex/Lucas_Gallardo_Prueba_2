
import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
  vus: 5,
  duration: '30s',
  thresholds: {
    http_req_failed: ['rate<0.01'],
    http_req_duration: ['p(95)<500'],
  },
};

export default function () {
  const url = 'http://localhost:8080/login';

  const payload = JSON.stringify({
    correo: 'usuario@empresa.cl',
    contrasena: 'Clave123',
  });

  const params = {
    headers: {
      'Content-Type': 'application/json',
    },
  };

  const response = http.post(url, payload, params);

  check(response, {
    'respuesta HTTP 200': (r) => r.status === 200,
    'acceso permitido': (r) =>
      r.body.includes('Acceso permitido'),
  });

  sleep(1);
}
