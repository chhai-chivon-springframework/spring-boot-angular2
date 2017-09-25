
export const API_END_POINT : String = 'http://localhost:8080/api/';

export const HEADER = {
  headers:{
    'Content-Type':'application/json'
  }
};

export const AUTH_CONFIG = (token) => {
  return {
    header:{
      'Content-Type':'application/json',
      'Authorization':'Bearer '+ token
    }
  }
};
