'use server';

import axios from 'axios';

export const listQueue = async () => {
  try {
    const response = await axios.get('http://localhost:8080/api/queue');
    return response.data;
  } catch (error) {
    console.error('Error fetching queue:', error);
    throw error;
  }
};

export const submitTriageData = async (data: any) => {
  try {
    await axios.post('http://localhost:8080/api/triage', data);
  } catch (error) {
    console.log(error);
    throw error;
  }
};