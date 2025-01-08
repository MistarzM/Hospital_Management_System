import axios from 'axios';

export const listTriages = async () => {
  try {
    const response = await axios.get('http://localhost:8080/api/triage');
    return response.data;
  } catch (error) {
    console.error('Error fetching triages:', error);
    throw error;
  }
};