<template>
  <div class="flex min-h-full flex-1 flex-col justify-center px-6 py-12 lg:px-8">
    <div class="sm:mx-auto sm:w-full sm:max-w-sm">
      <img
        class="mx-auto h-10 w-auto"
        src="https://tailwindui.com/plus/img/logos/mark.svg?color=indigo&shade=600"
        alt="Your Company"
      />
      <h2 class="mt-10 text-center text-2xl/9 font-bold tracking-tight text-gray-900">
        Take the next step and <br />help bring Munich together!
      </h2>
    </div>

    <div class="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
      <form class="space-y-2" @submit.prevent="showPopup">
        <div class="flex flex-row space-x-4 w-full justify-between">
          <div class="flex-1">
            <label for="firstName" class="block text-sm/6 font-medium text-gray-900">First Name</label>
            <div class="mt-2">
              <input
                id="firstName"
                name="firstName"
                required="true"
                class="block w-full rounded-md border-0 py-1.5 px-2 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm/6"
              />
            </div>
          </div>
          <div class="flex-1">
            <label for="lastName" class="block text-sm/6 font-medium text-gray-900">Last Name</label>
            <div class="mt-2">
              <input
                id="lastName"
                name="lastName"
                required="true"
                class="block w-full rounded-md border-0 py-1.5 px-2 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm/6"
              />
            </div>
          </div>
        </div>
        <div>
          <label for="email" class="block text-sm/6 font-medium text-gray-900">Email address</label>
          <div class="mt-2">
            <input
              id="email"
              name="email"
              type="email"
              autocomplete="email"
              required="true"
              class="block w-full rounded-md border-0 py-1.5 px-2 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm"            />
          </div>
        </div>

        <div>
          <div class="flex items-center justify-between">
            <label for="password" class="block text-sm/6 font-medium text-gray-900">Password</label>
          </div>
          <div class="mt-2">
            <input 
              id="password"
              name="password"
              type="password"
              autocomplete="current-password"
              required="true"
              class="block w-full rounded-md border-0 py-1.5 px-2 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm"            />
          </div>
        </div>

        <div class="pt-2">
          <button
            type="submit"
            class="flex w-full justify-center rounded-md bg-indigo-600 px-3 py-1.5 text-sm/6 font-semibold text-white shadow-sm hover:bg-indigo-500"
          >
            Register
          </button>
        </div>
      </form>

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
    </div>

    <p class="mt-10 text-center text-sm/6 text-gray-500">
      Alternatively
      <a href="#" class="font-semibold text-indigo-600 hover:text-indigo-500">Sign in using M-login</a>
    </p>
  </div>
</template>

<script setup>
import { ref, computed } from 'vue';
import PopupComponent from './Popup.vue';

const isPopupVisible = ref(false);

const currentStep = ref(0);
const steps = [
  { name: "Interests", href: "#", status: "complete", step: 0 },
  { name: "Languages", href: "#", status: "current", step: 1 },
  { name: "Event Types", href: "#", status: "upcoming", step: 2 },
];

const selectedItems = ref([]);

const showPopup = () => {
  isPopupVisible.value = true;
};

const closePopup = () => {
  isPopupVisible.value = false;
};

const updateStepStatuses = () => {
  steps.forEach((step, index) => {
    if (index < currentStep.value) {
      step.status = 'complete';
    } else if (index === currentStep.value) {
      step.status = 'current';
    } else {
      step.status = 'upcoming';
    }
  });
};

const handleSubmit = () => {
  console.log('Form submitted with selected items:', selectedItems.value);
};
</script>

<style scoped>
p {
  margin-top: 0px !important;
}

.card {
  width: 150px;
  height: 150px;
  margin-right: 10px;
}
</style>
