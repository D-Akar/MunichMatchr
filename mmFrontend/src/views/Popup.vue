
<template>
    
    <div
      v-if="isVisible"
      class="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-100"
    >
      <div class="bg-white shadow sm:rounded-lg w-3/5 h-2/3">
        <div class="px-4 py-5 sm:p-6 h-full flex flex-col">
          <h3 class="text-base font-semibold text-gray-900">
            Tell us more about yourself!
          </h3>
          <p class="text-sm text-gray-500 mt-2">
            Please be sure to select at least one item in each category.
          </p>
          <div class="h-max flex-col justify-between flex">
            <div class="mt-6 text-sm text-gray-500 flex flex-row space-x-4 w-full">
              <div class="flex-1 flex">
                <div class="flex flex-wrap gap-4">
                  <div
                    v-for="element in currentStepContent"
                    :key="element"
                    class="card flex justify-center items-center border rounded-lg border-black"
                    @click="toggleSelection(element)"
                    :class="{
                      'bg-blue-200': selectedItems.includes(element)
                    }"
                  >
                    {{ element }}
                  </div>
                </div>
              </div>
              <div class="pr-12 py-12 sm:px-6 lg:px-8 flex-3" id="progressList">
                <nav class="flex justify-center" aria-label="Progress">
                  <ol role="list" class="space-y-6">
                    <li v-for="step in steps" :key="step.name">
                      <a
                        v-if="step.status === 'complete'"
                        :href="step.href"
                        class="group"
                      >
                        <span class="flex items-start">
                          <span
                            class="relative flex size-5 shrink-0 items-center justify-center"
                          >
                            <CheckCircleIcon
                              class="size-full text-indigo-600 group-hover:text-indigo-800"
                              aria-hidden="true"
                            />
                          </span>
                          <span
                            class="ml-3 text-sm font-medium text-gray-500 group-hover:text-gray-900"
                          >
                            {{ step.name }}
                          </span>
                        </span>
                      </a>
                      <a
                        v-else-if="step.status === 'current'"
                        :href="step.href"
                        class="flex items-start"
                        aria-current="step"
                      >
                        <span
                          class="relative flex size-5 shrink-0 items-center justify-center"
                          aria-hidden="true"
                        >
                          <span class="absolute size-4 rounded-full bg-indigo-200" />
                          <span
                            class="relative block size-2 rounded-full bg-indigo-600"
                          />
                        </span>
                        <span class="ml-3 text-sm font-medium text-indigo-600">
                          {{ step.name }}
                        </span>
                      </a>
                      <a v-else :href="step.href" class="group flex items-start">
                        <div class="flex items-start">
                          <div
                            class="relative flex size-5 shrink-0 items-center justify-center"
                            aria-hidden="true"
                          >
                            <div
                              class="size-2 rounded-full bg-gray-300 group-hover:bg-gray-400"
                            />
                          </div>
                          <p
                            class="ml-3 text-sm font-medium text-gray-500 group-hover:text-gray-900"
                          >
                            {{ step.name }}
                          </p>
                        </div>
                      </a>
                    </li>
                  </ol>
                </nav>
              </div>
            </div>
            <div class="mt-5 flex justify-center space-x-4">
              <button
                type="button"
                :disabled="currentStep === 0"
                :class="[
                  'inline-flex items-center rounded-md px-3 py-2 text-sm font-semibold text-white shadow-sm focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-500',
                  currentStep === 0 ? 'bg-gray-400' : 'bg-indigo-600 hover:bg-indigo-500'
                ]"
                @click="goToPreviousStep"
              >
                Previous
              </button>
              <button
                type="button"
                class="inline-flex items-center rounded-md bg-indigo-600 px-3 py-2 text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-500"
                @click="submitSelections"
              >
                Submit
              </button>
              <button
                type="button"
                :disabled="currentStep === steps.length - 1"
                :class="[
                  'inline-flex items-center rounded-md px-3 py-2 text-sm font-semibold text-white shadow-sm focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-500',
                  currentStep === steps.length - 1 ? 'bg-gray-400' : 'bg-indigo-600 hover:bg-indigo-500'
                ]"
                @click="goToNextStep"
              >
                Next
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref, computed } from 'vue';
  import { CheckCircleIcon } from "@heroicons/vue/20/solid";
  
  const props = defineProps({
    isVisible: Boolean,
    steps: Array,
    currentStep: Number,
    selectedItems: Array,
  });
  
  const emit = defineEmits(['close', 'submit']);
  const currentStepContent = computed(() => stepElements[props.currentStep]);
  
  const goToNextStep = () => {
    if (props.currentStep < props.steps.length - 1) {
      emit('update:currentStep', props.currentStep + 1);
    }
  };
  
  const goToPreviousStep = () => {
    if (props.currentStep > 0) {
      emit('update:currentStep', props.currentStep - 1);
    }
  };
  
  const toggleSelection = (item) => {
    if (props.selectedItems.includes(item)) {
      props.selectedItems.splice(props.selectedItems.indexOf(item), 1);
    } else {
      props.selectedItems.push(item);
    }
  };
  
  const submitSelections = () => {
    emit('submit', props.selectedItems);
    emit('close');
  };
  
  const stepElements = {
    0: ["Literature", "Sports", "Cooking"],
    1: ["English", "German", "Turkish", "Mandarin", "Vietnamese", "Arabic"],
    2: ["Elderly Care", "Language Cafes", "Youth Institutions"],
  };
  </script>
  
  <style scoped>
  .bg-black.bg-opacity-50 {
    pointer-events: none; 
  }
  
  .bg-white {
    pointer-events: auto; 
    z-index: 9999; 
    overflow: hidden; 
  }
  
  .card {
    width: 150px;
    height: 150px;
    margin-right: 10px;
    cursor: pointer; 
  }
  
  .card.bg-blue-200 {
    background-color: #ebf4ff;
  }
  </style>
  