<template>
  <main class="flex h-full flex-col">
    <HeaderBlock />
    <Section>
      <div class="flex h-full w-full items-center justify-center flex-col">
        <h1 class="text-3xl font-bold mb-6">Profile</h1>
        <p class="text-gray-500 mb-8">Manage your personal information below.</p>

        <div class="w-full max-w-4xl bg-white p-6 rounded-lg shadow-lg">
          <div class="mb-6">
            <p class="text-lg font-semibold">
              Events Attended: <span class="text-indigo-600">{{ attendedEvents }}</span>
            </p>
          </div>
          <div class="grid grid-cols-1 md:grid-cols-2 gap-6">
            <div>
              <label for="firstName" class="block text-sm font-medium text-gray-700">First Name</label>
              <input v-model="profileData.firstName" type="text" id="firstName" 
                class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-500 focus:ring-indigo-500 px-2" />
            </div>
            <div>
              <label for="lastName" class="block text-sm font-medium text-gray-700">Last Name</label>
              <input v-model="profileData.lastName" type="text" id="lastName"
                class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-500 focus:ring-indigo-500 px-2" />
            </div>
            <div>
              <label for="email" class="block text-sm font-medium text-gray-700">Email</label>
              <input v-model="profileData.email" type="email" id="email"
                class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-500 focus:ring-indigo-500 px-2" />
            </div>
            <div>
              <label for="address" class="block text-sm font-medium text-gray-700">Address</label>
              <input v-model="profileData.address" type="text" id="address"
                class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-500 focus:ring-indigo-500 px-2" />
            </div>
            <div>
              <label for="phone" class="block text-sm font-medium text-gray-700">Phone</label>
              <input v-model="profileData.phone" type="tel" id="phone"
                class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-500 focus:ring-indigo-500 px-2" />
            </div>
          </div>

          <!-- two buttons -->
          <div class="flex justify-between items-center mt-8">
            <button
              class="bg-gray-200 text-gray font-bold py-2 px-6 rounded text-sm hover:bg-gray-300 focus:outline-none"
              @click="handleInterests">
              Change Interests
            </button>
            <button class="bg-[#4338CA] text-white font-bold py-2 px-6 rounded hover:bg-[#4438AA] focus:outline-none"
              @click="handleSave">
              Save Changes
            </button>
          </div>
        </div>
      </div>
    </Section>
    <PopupComponent
      v-if="isPopupVisible"
      :isVisible="isPopupVisible"
      :steps="steps"
      :currentStep="currentStep"
      :selectedItems="selectedItems"
      @close="closePopup"
      @submit="handleSubmit"
      @update:currentStep="currentStep = $event"
    />
  </main>
</template>

<script setup>
import HeaderBlock from "@/components/HeaderBlock.vue";
import PopupComponent from './Popup.vue';
import { ref, onMounted } from "vue";
import { useRouter } from 'vue-router';

const router = useRouter();

// example data would be pulled from somewhere
const profileData = ref({
  firstName: "Max",
  lastName: "Mustermann",
  email: "max@example.de",
  address: "101",
  phone: "+49155462014",
});

const isPopupVisible = ref(false);
const currentStep = ref(0);
const steps = [
  { name: "Interests", href: "#", status: "complete", step: 0 },
  { name: "Languages", href: "#", status: "current", step: 1 },
  { name: "Event Types", href: "#", status: "upcoming", step: 2 },
];
const selectedItems = ref([]);
const attendedEvents = ref(4);

const showPopup = () => {
  isPopupVisible.value = true;
};

//for backend
const handleSave = () => {
  router.push({ name: 'Dashboard' });
  const updatedProfileData = {
    firstName: profileData.value.firstName,
    lastName: profileData.value.lastName,
    email: profileData.value.email,
    address: profileData.value.address,
    phone: profileData.value.phone,
  };
};

const closePopup = () => {
  isPopupVisible.value = false;
  router.push({ name: 'Profile' });
};

const handleSubmit = () => {
  console.log('Interests submitted with selected items:', selectedItems.value);
  closePopup();
  router.push({ name: 'Profile' });
};

const fetchUserData = async () => {
  const userEmail = localStorage.getItem('userEmail');
  if (userEmail) {
    try {
      const response = await fetch(`http://localhost:8080/user/get/${userEmail}`);
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      const data = await response.json();
      const { eventCounter, name } = data;
      profileData.value.firstName = name;
      profileData.value.lastName = name;
      attendedEvents.value = eventCounter;
    } catch (error) {
      console.error("Error fetching user data:", error);
    }
  }
};

// Fetch user data when the component is mounted
onMounted(() => {
  fetchUserData();
});

const handleInterests = () => {
  showPopup();
};
</script>
