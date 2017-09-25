
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
