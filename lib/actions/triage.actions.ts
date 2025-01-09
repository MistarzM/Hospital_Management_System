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

export const fetchVisitInfo = async (triageId: number) => {
  try {
    const response = await fetch(`http://localhost:8080/api/visit/${triageId}`);
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    const data = await response.json();
    return data;
  } catch (error) {
    console.error('Error fetching info:', error);
    throw error;
  }
};

export const updateTriageStatus = async (data: {
  id: number;
  triageId: number;
  priorityLevel: string;
  priorityPoints: number;
  status: string;
}) => {
  try {
    await axios.put(`http://localhost:8080/api/queue/${data.id}`, data);
  } catch (error) {
    console.error('Error updating status:', error);
    throw error;
  }
};